package com.devtypes.retrospec.dailyjournal.dailybullet;

import com.devtypes.retrospec.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class DailyBulletConverter extends AbstractConverter<DailyBullet, DailyBulletVo> {

    public DailyBulletConverter(DozerBeanMapper mapper) {
        super(mapper, DailyBullet.class, DailyBulletVo.class);
    }

}
