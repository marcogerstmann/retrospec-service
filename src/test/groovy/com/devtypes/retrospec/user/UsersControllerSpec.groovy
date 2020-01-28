package com.devtypes.retrospec.user

import com.devtypes.retrospec.common.enums.RetrospecEntity
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException
import com.devtypes.retrospec.usersetting.UserSettingService
import spock.lang.Specification

class UsersControllerSpec extends Specification {
    UserService userService = Mock()
    UserSettingService userSettingService = Mock()
    UsersController controller

    def setup() {
        controller = new UsersController(userService, userSettingService)
    }

    def "GET endpoint call"() {
        given: "a list of users"
        userService.findAll() >> [new UserVo(), new UserVo()]

        when: "GET endpoint is called"
        def endpointResult = controller.index()

        then: "the list of users is returned"
        endpointResult.body.size() == 2
    }

    def "GET /{id} endpoint call"() {
        given: "an empty return value from the service"
        userService.findById(_ as UUID) >> Optional.empty()

        when: "GET /{id} endpoint is called"
        controller.get(UUID.randomUUID())

        then: "not found exception is thrown"
        def thrown = thrown(RetrospecNotFoundException)

        and: "entity type of exception is USER"
        thrown.notFoundEntity == RetrospecEntity.USER
    }

    def "GET /{id}/settings endpoint call"() {
        given: "an empty return value from the service"
        userSettingService.findByUserId(_ as UUID) >> Optional.empty()

        when: "GET /{id} endpoint is called"
        controller.getSettings(UUID.randomUUID())

        then: "not found exception is thrown"
        def thrown = thrown(RetrospecNotFoundException)

        and: "entity type of exception is USER_SETTING"
        thrown.notFoundEntity == RetrospecEntity.USER_SETTING
    }

    def "POST endpoint call"() {
        when: "POST endpoint is called"
        controller.post(new UserVo())

        then: "service is called for creation"
        1 * userService.create(_)
    }

    def "PUT endpoint call"() {
        when: "PUT endpoint is called"
        controller.put(UUID.randomUUID(), new UserVo())

        then: "service is called for update"
        1 * userService.updateById(_, _)
    }

    def "DELETE endpoint call"() {
        when: "DELETE endpoint is called"
        controller.delete(UUID.randomUUID())

        then: "service is called for deletion"
        1 * userService.deleteById(_)
    }

}
