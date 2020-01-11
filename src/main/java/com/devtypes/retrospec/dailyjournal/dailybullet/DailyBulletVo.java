package com.devtypes.retrospec.dailyjournal.dailybullet;

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
public class DailyBulletVo extends BaseVo {

    @NotNull
    private UUID dailyJournalId;

    @NotNull
    @NotBlank
    private String text;

}
