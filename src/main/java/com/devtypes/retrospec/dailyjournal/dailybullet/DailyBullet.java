package com.devtypes.retrospec.dailyjournal.dailybullet;

import com.devtypes.retrospec.common.base.BaseEntity;
import com.devtypes.retrospec.dailyjournal.DailyJournal;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
public class DailyBullet extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "daily_journal_id")
    private DailyJournal dailyJournal;

    @NotNull
    @Column(name = "daily_journal_id", insertable = false, updatable = false)
    private UUID dailyJournalId;

    @NotNull
    @NotBlank
    private String text;

}
