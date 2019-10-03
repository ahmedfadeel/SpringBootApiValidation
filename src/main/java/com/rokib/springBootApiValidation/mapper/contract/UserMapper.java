package com.rokib.springBootApiValidation.mapper.contract;


import com.rokib.springBootApiValidation.dto.request.SignUpCommand;
import com.rokib.springBootApiValidation.persistence.entity.User;

public interface UserMapper {
    User createUserFromCommand(SignUpCommand signUpCommand);
}
