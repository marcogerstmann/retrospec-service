package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseVo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ParametersAreNonnullByDefault
@NoArgsConstructor
@Setter
public class UserSettingVo extends BaseVo {

    @NotNull
    private UUID userId;

    private String language;

}
