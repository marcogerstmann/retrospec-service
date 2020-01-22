package com.devtypes.retrospec.habit;

import com.devtypes.retrospec.common.base.BaseDataServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class HabitServiceImpl extends BaseDataServiceImpl<Habit, HabitVo> implements HabitService {

    public HabitServiceImpl(HabitRepository habitRepository, HabitConverter habitConverter) {
        super(habitRepository, habitConverter);
    }

}
