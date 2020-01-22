package com.devtypes.retrospec.habit

import com.devtypes.retrospec.common.enums.RetrospecEntity
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException
import spock.lang.Specification

class HabitsControllerSpec extends Specification {
    HabitService habitService = Mock()
    HabitsController controller

    def setup() {
        controller = new HabitsController(habitService)
    }

    def "GET endpoint call"() {
        given: "a list of habits"
        habitService.findAll() >> [new HabitVo(), new HabitVo()]

        when: "GET endpoint is called"
        def endpointResult = controller.index()

        then: "the list of habits is returned"
        endpointResult.body.size() == 2
    }

    def "GET /{id} endpoint call"() {
        given: "an empty return value from the service"
        habitService.findById(_ as UUID) >> Optional.empty()

        when: "GET /{id} endpoint is called"
        controller.get(UUID.randomUUID())

        then: "not found exception is thrown"
        def thrown = thrown(RetrospecNotFoundException)

        and: "entity type of exception is HABIT"
        thrown.notFoundEntity == RetrospecEntity.HABIT
    }

    def "POST endpoint call"() {
        when: "POST endpoint is called"
        controller.post(new HabitVo())

        then: "service is called for creation"
        1 * habitService.create(_)
    }

    def "PUT endpoint call"() {
        when: "PUT endpoint is called"
        controller.put(UUID.randomUUID(), new HabitVo())

        then: "service is called for update"
        1 * habitService.updateById(_, _)
    }

    def "DELETE endpoint call"() {
        when: "DELETE endpoint is called"
        controller.delete(UUID.randomUUID())

        then: "service is called for deletion"
        1 * habitService.deleteById(_)
    }

}
