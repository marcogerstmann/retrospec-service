package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseEntity;
import com.devtypes.retrospec.user.User;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
public class UserSetting extends BaseEntity {

    @Column(name = "user_id", updatable = false)
    private UUID userId;

    private String language;

}
