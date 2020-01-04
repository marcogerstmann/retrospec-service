package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseEntityModel;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@ParametersAreNonnullByDefault
public class Journal extends BaseEntityModel {

    @NotBlank
    private String name;

}
