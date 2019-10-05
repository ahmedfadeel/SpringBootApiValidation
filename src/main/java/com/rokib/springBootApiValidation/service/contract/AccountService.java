package com.rokib.springBootApiValidation.service.contract;


import com.rokib.springBootApiValidation.dto.account.request.SignUpCommand;
import com.rokib.springBootApiValidation.persistence.entity.User;

public interface AccountService {
    User createUser(SignUpCommand signUpCommand);
}
