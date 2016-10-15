package com.cooking.finder.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Created by Igor on 15.10.2016.
 */
@Getter
@Setter
public class User extends IdModel {

    @NotNull
    @NotEmpty
    @Length(min = 8)
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String accessToken;

    @NotNull
    @NotEmpty
    private DateTime accessTokenCreation;

}
