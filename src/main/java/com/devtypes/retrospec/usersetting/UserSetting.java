package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseEntity;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
public class UserSetting extends BaseEntity {

    @Column(updatable = false)
    @NotNull
    private UUID userId;

    private String language;

}
