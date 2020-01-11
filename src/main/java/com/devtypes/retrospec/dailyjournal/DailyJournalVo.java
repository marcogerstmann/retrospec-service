package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.base.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@ParametersAreNonnullByDefault
@NoArgsConstructor
@Setter
public class DailyJournalVo extends BaseVo {

    @NotNull
    private UUID userId;

    @NotNull
    private Date logDate;

    @Min(0)
    @Max(10)
    private Integer moodPoints;

    private String habits;

}
