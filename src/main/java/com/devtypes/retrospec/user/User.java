package com.devtypes.retrospec.user;

import com.devtypes.retrospec.common.base.BaseEntity;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@ParametersAreNonnullByDefault
@Table(name = "user_account")
public class User extends BaseEntity {

    @NotBlank
    private String email;

    private String firstName;

    private String lastName;

}
