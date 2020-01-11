package com.devtypes.retrospec.user;

import com.devtypes.retrospec.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<User, UserVo> {

    public UserConverter(DozerBeanMapper mapper) {
        super(mapper, User.class, UserVo.class);
    }

}
