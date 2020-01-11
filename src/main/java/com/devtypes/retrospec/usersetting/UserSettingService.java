package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseDataService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class UserSettingService extends BaseDataService<UserSetting, UserSettingVo> implements IUserSettingService {

    public UserSettingService(UserSettingRepository userRepository, UserSettingConverter userConverter) {
        super(userRepository, userConverter);
    }

}
