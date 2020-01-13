package com.devtypes.retrospec.dailyjournal.dailyhabit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyHabitVo implements Serializable {

    private UUID habitId;

    private String habitName;

    private Boolean checked;

}
