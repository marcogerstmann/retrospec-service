package com.devtypes.retrospec.habit;

import com.devtypes.retrospec.common.base.BaseDataService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class HabitService extends BaseDataService<Habit, HabitVo> implements IHabitService {

    public HabitService(HabitRepository habitRepository, HabitConverter habitConverter) {
        super(habitRepository, habitConverter);
    }

}
