package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class UserSettingConverter extends AbstractConverter<UserSetting, UserSettingVo> {

    public UserSettingConverter(DozerBeanMapper mapper) {
        super(mapper, UserSetting.class, UserSettingVo.class);
    }

}
