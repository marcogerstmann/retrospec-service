package com.devtypes.retrospec.user;

import com.devtypes.retrospec.common.base.BaseDataServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class UserServiceImpl extends BaseDataServiceImpl<User, UserVo> implements UserService {

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        super(userRepository, userConverter);
    }

}
