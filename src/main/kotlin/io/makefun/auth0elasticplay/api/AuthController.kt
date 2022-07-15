package io.makefun.auth0elasticplay.api

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/secured")
class AuthController {

    @GetMapping("/public")
    fun public() {
        log.info { "Accessed /secured/public API" }
    }

    @GetMapping("/private")
    fun private() {
        log.info { "Accessed /secured/private API" }
    }

    @GetMapping("/private-role")
    fun privateRole() {
        log.info { "Accessed /secured/private-role API" }
    }
}