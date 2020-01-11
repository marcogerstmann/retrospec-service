package com.devtypes.retrospec.habit;

import com.devtypes.retrospec.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class HabitConverter extends AbstractConverter<Habit, HabitVo> {

    public HabitConverter(DozerBeanMapper mapper) {
        super(mapper, Habit.class, HabitVo.class);
    }

}
