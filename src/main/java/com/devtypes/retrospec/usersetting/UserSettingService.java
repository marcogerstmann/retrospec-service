package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.BaseDataService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class UserSettingService extends BaseDataService<UserSetting, UserSettingVo> implements IUserSettingService {

    private UserSettingRepository userSettingRepository;
    private UserSettingConverter userSettingConverter;

    public UserSettingService(UserSettingRepository userSettingRepository, UserSettingConverter userSettingConverter) {
        super(userSettingRepository, userSettingConverter);
        this.userSettingRepository = userSettingRepository;
        this.userSettingConverter = userSettingConverter;
    }

    @Override
    public Optional<UserSettingVo> findByUserId(UUID userId) {
        System.out.println(userSettingRepository.findByUserId(userId));
        System.out.println(userSettingRepository.findByUserId(userId).map(userSettingConverter::convertEntityToVo));
        return userSettingRepository.findByUserId(userId).map(userSettingConverter::convertEntityToVo);
    }
}
