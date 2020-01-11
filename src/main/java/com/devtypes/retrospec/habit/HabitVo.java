package com.devtypes.retrospec.habit;

import com.devtypes.retrospec.common.base.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ParametersAreNonnullByDefault
@NoArgsConstructor
@Setter
public class HabitVo extends BaseVo {

    @NotNull
    private UUID userId;

    @NotBlank
    @NotNull
    private String name;

}
