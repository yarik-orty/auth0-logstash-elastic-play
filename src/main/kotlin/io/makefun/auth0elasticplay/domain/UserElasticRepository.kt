package io.makefun.auth0elasticplay.domain

import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface UserElasticRepository : ElasticsearchRepository<UserEntity, String> {

    fun findByEmail(email: String): List<UserEntity>

    @Query("{\"bool\": {\"must\": [{\"match\": {\"users.name\": \"?0\"}}]}}")
    fun findByName(name: String): List<UserEntity>
}