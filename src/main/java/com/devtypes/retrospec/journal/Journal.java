package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseEntity;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@ParametersAreNonnullByDefault
public class Journal extends BaseEntity {

    @NotBlank
    private String name;

}
