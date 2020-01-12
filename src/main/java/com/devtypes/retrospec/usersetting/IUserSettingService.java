package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.IDataService;

import java.util.Optional;
import java.util.UUID;

public interface IUserSettingService extends IDataService<UserSettingVo> {

    Optional<UserSettingVo> findByUserId(UUID userId);

}
