package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.constraints.NotBlank;

@Data
@ParametersAreNonnullByDefault
@NoArgsConstructor
@Setter
public class JournalVo extends BaseVo {

    @NotBlank
    private String name;

}
