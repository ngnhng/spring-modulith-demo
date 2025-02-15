package com.ngnhng.demo

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules

class SpringModulithTest {
    private val modules = ApplicationModules.of(DemoApplication::class.java)

    @Test
    fun shouldCompliantWithModulithRules() {
        modules.verify()
    }
}