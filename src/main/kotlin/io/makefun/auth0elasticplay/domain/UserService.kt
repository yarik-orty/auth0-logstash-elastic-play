package io.makefun.auth0elasticplay.domain

import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository,
                  private val elasticRepository: UserElasticRepository) {

    fun users(): List<User> {
        return repository.users()
    }

    fun findById(id: Int): User {
        return repository.findById(id) ?: throw IllegalStateException("User not found for id=$id")
    }

    fun create(user: User) {
        repository.create(user)
    }

    fun search(search: String): List<UserEntity> {
        return elasticRepository.findByEmail(search)
    }
}