// Copyright 2014-2019 Xvela. All Rights Reserved.

package com.retrospec.berth

import com.devtypes.retrospec.RetrospecApplication
import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.github.springtestdbunit.annotation.DbUnitConfiguration
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RetrospecApplication.class)
@ActiveProfiles('test')
@TestExecutionListeners([
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class])
@DbUnitConfiguration(databaseConnection = ["dbUnitDatabaseConnection"])
class AbstractIntegrationSpec extends Specification {

    @LocalServerPort
    private int port

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8280) // No-args constructor defaults to port 8080

}
