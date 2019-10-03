package com.rokib.springBootApiValidation.mapper.impl;


import com.rokib.springBootApiValidation.dto.request.SignUpCommand;
import com.rokib.springBootApiValidation.mapper.contract.UserMapper;
import com.rokib.springBootApiValidation.persistence.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User createUserFromCommand(SignUpCommand signUpCommand) {
        User user = new User();
        user.setFirstName(signUpCommand.getFirstName());
        user.setLastName(signUpCommand.getLastName());
        user.setEmail(signUpCommand.getEmail());
        return user;
    }
}
