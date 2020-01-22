package com.devtypes.retrospec.dailyjournal

import com.devtypes.retrospec.common.enums.RetrospecEntity
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException
import spock.lang.Specification

class DailyJournalsControllerSpec extends Specification {
    DailyJournalService dailyJournalService = Mock()
    DailyJournalsController controller

    def setup() {
        controller = new DailyJournalsController(dailyJournalService)
    }

    def "GET endpoint call"() {
        given: "a list of daily journals"
        dailyJournalService.findAll() >> [new DailyJournalVo(), new DailyJournalVo()]

        when: "GET endpoint is called"
        def endpointResult = controller.index()

        then: "the list of daily journals is returned"
        endpointResult.body.size() == 2
    }

    def "GET /{id} endpoint call"() {
        given: "an empty return value from the service"
        dailyJournalService.findById(_ as UUID) >> Optional.empty()

        when: "GET /{id} endpoint is called"
        controller.get(UUID.randomUUID())

        then: "not found exception is thrown"
        def thrown = thrown(RetrospecNotFoundException)

        and: "entity type of exception is DAILY_JOURNAL"
        thrown.notFoundEntity == RetrospecEntity.DAILY_JOURNAL
    }

    def "POST endpoint call"() {
        when: "POST endpoint is called"
        controller.post(new DailyJournalVo())

        then: "service is called for creation"
        1 * dailyJournalService.create(_)
    }

    def "PUT endpoint call"() {
        when: "PUT endpoint is called"
        controller.put(UUID.randomUUID(), new DailyJournalVo())

        then: "service is called for update"
        1 * dailyJournalService.updateById(_, _)
    }

    def "DELETE endpoint call"() {
        when: "DELETE endpoint is called"
        controller.delete(UUID.randomUUID())

        then: "service is called for deletion"
        1 * dailyJournalService.deleteById(_)
    }

}
