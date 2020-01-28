package com.devtypes.retrospec.usersetting

import com.devtypes.retrospec.common.enums.RetrospecEntity
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException
import spock.lang.Specification

class UserSettingSettingsControllerSpec extends Specification {
    UserSettingService userSettingService = Mock()
    UserSettingsController controller

    def setup() {
        controller = new UserSettingsController(userSettingService)
    }

    def "GET /{id} endpoint call"() {
        given: "an empty return value from the service"
        userSettingService.findById(_ as UUID) >> Optional.empty()

        when: "GET /{id} endpoint is called"
        controller.get(UUID.randomUUID())

        then: "not found exception is thrown"
        def thrown = thrown(RetrospecNotFoundException)

        and: "entity type of exception is USER_SETTING"
        thrown.notFoundEntity == RetrospecEntity.USER_SETTING
    }

    def "POST endpoint call"() {
        when: "POST endpoint is called"
        controller.post(new UserSettingVo())

        then: "service is called for creation"
        1 * userSettingService.create(_)
    }

    def "PUT endpoint call"() {
        when: "PUT endpoint is called"
        controller.put(UUID.randomUUID(), new UserSettingVo())

        then: "service is called for update"
        1 * userSettingService.updateById(_, _)
    }

    def "DELETE endpoint call"() {
        when: "DELETE endpoint is called"
        controller.delete(UUID.randomUUID())

        then: "service is called for deletion"
        1 * userSettingService.deleteById(_)
    }

}
