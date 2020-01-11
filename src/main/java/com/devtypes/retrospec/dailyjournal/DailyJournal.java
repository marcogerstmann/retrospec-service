package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.base.BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@ParametersAreNonnullByDefault
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class DailyJournal extends BaseEntity {

    @NotNull
    private UUID userId;

    @NotNull
    private Date logDate;

    @Min(0)
    @Max(10)
    private Integer moodPoints;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String habits;

}
