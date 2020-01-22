package com.devtypes.retrospec.dailyjournal.dailybullet;

import com.devtypes.retrospec.common.base.BaseDataServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class DailyBulletServiceImpl extends BaseDataServiceImpl<DailyBullet, DailyBulletVo> implements DailyBulletService {

    public DailyBulletServiceImpl(DailyBulletRepository dailyBulletRepository, DailyBulletConverter dailyBulletConverter) {
        super(dailyBulletRepository, dailyBulletConverter);
    }

}
