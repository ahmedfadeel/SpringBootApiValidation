package com.rokib.springBootApiValidation.service.impl;


import com.rokib.springBootApiValidation.dto.request.SignUpCommand;
import com.rokib.springBootApiValidation.mapper.contract.UserMapper;
import com.rokib.springBootApiValidation.persistence.entity.User;
import com.rokib.springBootApiValidation.persistence.repository.UserRepository;
import com.rokib.springBootApiValidation.service.contract.AccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(
            UserMapper userMapper,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(SignUpCommand signUpRequest) {
        User user = userMapper.createUserFromCommand(signUpRequest);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userRepository.save(user);
    }

}
