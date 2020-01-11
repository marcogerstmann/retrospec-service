package com.devtypes.retrospec.user;

import com.devtypes.retrospec.common.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@ParametersAreNonnullByDefault
@Table(name = "user_account")
public class User extends BaseEntity {

    @NotNull
    @NotBlank
    @NaturalId
    private String email;

    private String firstName;

    private String lastName;

}
