package com.devtypes.retrospec.habit

import spock.lang.Specification

class HabitsControllerSpec extends Specification {
    IHabitService habitService = Mock()
    HabitsController controller

    def setup() {
        controller = new HabitsController(habitService)
    }

    def "index endpoint should return a list of all habits"() {
        given: "a list of habits"
        habitService.findAll() >> [new HabitVo(), new HabitVo()]

        when: "index endpoint is called"
        def endpointResult = controller.index()

        then: "the list of habits is returned"
        endpointResult.body.size() == 2
    }
}
