package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.constraints.NotBlank;

@ParametersAreNonnullByDefault
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class JournalVo extends BaseVo {

    @NotBlank
    private String name;

}
