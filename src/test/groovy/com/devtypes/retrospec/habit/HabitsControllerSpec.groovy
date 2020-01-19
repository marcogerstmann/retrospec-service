package com.devtypes.retrospec.habit

import com.devtypes.retrospec.common.enums.RetrospecEntity
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException
import spock.lang.Specification

class HabitsControllerSpec extends Specification {
    IHabitService habitService = Mock()
    HabitsController controller

    def setup() {
        controller = new HabitsController(habitService)
    }

    def "GET endpoint should return a list of all habits"() {
        given: "a list of habits"
        habitService.findAll() >> [new HabitVo(), new HabitVo()]

        when: "GET endpoint is called"
        def endpointResult = controller.index()

        then: "the list of habits is returned"
        endpointResult.body.size() == 2
    }

    def "GET /{id} should throw 404 if habit is not found"() {
        given: "an empty return value from the service"
        habitService.findById(_ as UUID) >> Optional.empty()

        when: "GET /{id} endpoint is called"
        controller.get(UUID.randomUUID())

        then: "not found exception is thrown"
        def thrown = thrown(RetrospecNotFoundException)

        and: "entity type of exception is HABIT"
        thrown.notFoundEntity == RetrospecEntity.HABIT
    }

}
