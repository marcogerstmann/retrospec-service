package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseDataService;

import java.util.Optional;
import java.util.UUID;

public interface UserSettingService extends BaseDataService<UserSettingVo> {

    Optional<UserSettingVo> findByUserId(UUID userId);

}
