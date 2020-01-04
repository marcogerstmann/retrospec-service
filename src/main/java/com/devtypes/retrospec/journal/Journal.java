package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseEntityModel;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Journal extends BaseEntityModel {

    @NotBlank
    private String name;

}
