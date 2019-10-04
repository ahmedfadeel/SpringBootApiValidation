package com.rokib.springBootApiValidation.persistence.entity;

import com.rokib.springBootApiValidation.constants.FieldConstraints;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = FieldConstraints.ForUser.MAX_EMAIL_LENGTH)
    private String email;

    @Column(nullable = false, length = FieldConstraints.ForUser.MAX_ENCRYPTED_PASSWORD_LENGTH)
    private String password;

    @Column(nullable = false, length = FieldConstraints.ForUser.MAX_FIRST_NAME_LENGTH)
    private String firstName;

    @Column(length = FieldConstraints.ForUser.MAX_LAST_NAME_LENGTH)
    private String lastName;

}
