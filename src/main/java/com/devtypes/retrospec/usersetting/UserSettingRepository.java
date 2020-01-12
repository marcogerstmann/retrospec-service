package com.devtypes.retrospec.usersetting;

import java.util.Optional;
import java.util.UUID;

public interface UserSettingRepository extends org.springframework.data.jpa.repository.JpaRepository<UserSetting, UUID> {

    Optional<UserSetting> findByUserId(UUID userId);

}
