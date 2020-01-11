package com.devtypes.retrospec.dailyjournal.dailybullet;

import com.devtypes.retrospec.common.base.BaseEntity;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
public class DailyBullet extends BaseEntity {

    @NotNull
    private UUID dailyJournalId;

    @NotNull
    @NotBlank
    private String text;

}
