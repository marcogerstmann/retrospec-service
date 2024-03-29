package com.devtypes.retrospec.common.exception

import com.devtypes.retrospec.common.enums.RetrospecEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class RestExceptionHandlerSpec extends Specification {

    private RestExceptionHandler restExceptionHandler = new RestExceptionHandler()

    def 'handle business exception'() {
        given: 'runtime exception'
        RuntimeException exception = new RetrospecBusinessException("A business logic error message")

        when: 'handler is called'
        ResponseEntity responseEntity = restExceptionHandler.handleBusinessException(exception)

        then: 'status code is 422 (UNPROCESSABLE ENTITY)'
        responseEntity.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY
    }

    def 'handle not found exception'() {
        given: 'runtime exception'
        RuntimeException exception = new RetrospecNotFoundException(RetrospecEntity.DAILY_JOURNAL, UUID.randomUUID())

        when: 'handler is called'
        ResponseEntity responseEntity = restExceptionHandler.handleNotFoundException(exception)

        then: 'status code is 404 (NOT FOUND)'
        responseEntity.getStatusCode() == HttpStatus.NOT_FOUND
    }

    // TODO: Implement again when using Spring Boot Security
//    def 'handle access denied exception'() {
//        given: 'runtime exception'
//        RuntimeException exception = new AccessDeniedException("Access denied")
//
//        when: 'handler is called'
//        ResponseEntity responseEntity = restExceptionHandler.handleAccessDeniedException(exception)
//
//        then: 'status code is 403 (FORBIDDEN)'
//        responseEntity.getStatusCode() == HttpStatus.FORBIDDEN
//    }

}
