package com.devtypes.retrospec.dailyjournal.dailybullet;

import com.devtypes.retrospec.common.base.BaseDataService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class DailyBulletService extends BaseDataService<DailyBullet, DailyBulletVo> implements IDailyBulletService {

    public DailyBulletService(DailyBulletRepository dailyBulletRepository, DailyBulletConverter dailyBulletConverter) {
        super(dailyBulletRepository, dailyBulletConverter);
    }

}
