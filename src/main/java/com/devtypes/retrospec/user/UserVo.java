package com.devtypes.retrospec.user;

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
public class UserVo extends BaseVo {

    @NotBlank
    private String email;

    private String firstName;

    private String lastName;

}
