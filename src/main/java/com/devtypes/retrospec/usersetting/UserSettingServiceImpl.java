package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseDataServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class UserSettingServiceImpl extends BaseDataServiceImpl<UserSetting, UserSettingVo> implements UserSettingService {

    private UserSettingRepository userSettingRepository;
    private UserSettingConverter userSettingConverter;

    public UserSettingServiceImpl(UserSettingRepository userSettingRepository, UserSettingConverter userSettingConverter) {
        super(userSettingRepository, userSettingConverter);
        this.userSettingRepository = userSettingRepository;
        this.userSettingConverter = userSettingConverter;
    }

    @Override
    public Optional<UserSettingVo> findByUserId(UUID userId) {
        return userSettingRepository.findByUserId(userId).map(userSettingConverter::convertEntityToVo);
    }
}
