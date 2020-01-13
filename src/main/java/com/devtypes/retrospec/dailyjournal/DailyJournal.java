package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.base.BaseEntity;
import com.devtypes.retrospec.dailyjournal.dailybullet.DailyBullet;
import lombok.Data;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
public class DailyJournal extends BaseEntity {

    @NotNull
    private UUID userId;

    @NotNull
    private Date logDate;

    @Min(0)
    @Max(10)
    private Integer moodPoints;

    private String habits;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dailyJournal")
    private List<DailyBullet> bullets;

}
