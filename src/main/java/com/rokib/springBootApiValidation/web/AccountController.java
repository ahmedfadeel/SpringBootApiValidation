package com.rokib.springBootApiValidation.web;

import com.rokib.springBootApiValidation.dto.request.SignUpCommand;
import com.rokib.springBootApiValidation.persistence.entity.User;
import com.rokib.springBootApiValidation.service.contract.AccountService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/account", produces = {"application/json"}, consumes = {"application/json"})
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Successfully created", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request or Validation Failed"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED) // ==> This is define to turn off default response messages
    @PostMapping(path = "/sign-up")
    public ResponseEntity<User> signUp(@Valid @RequestBody SignUpCommand signUpCommand) {
        return new ResponseEntity<User>(accountService.createUser(signUpCommand), HttpStatus.CREATED);
    }
}
