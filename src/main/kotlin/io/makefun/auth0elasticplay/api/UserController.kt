package io.makefun.auth0elasticplay.api

import io.makefun.auth0elasticplay.domain.User
import io.makefun.auth0elasticplay.domain.UserEntity
import io.makefun.auth0elasticplay.domain.UserService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun users(): List<User> {
        return service.users()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): User {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody user: User) {
        service.create(user)
    }

    @GetMapping("/search")
    fun search(@RequestParam search: String): List<UserEntity> {
        return service.search(search)
    }
}