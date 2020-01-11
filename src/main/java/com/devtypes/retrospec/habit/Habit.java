package com.devtypes.retrospec.habit;

import com.devtypes.retrospec.common.base.BaseEntity;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
public class Habit extends BaseEntity {

    @NotNull
    private UUID userId;

    @NotBlank
    @NotNull
    private String name;

}
