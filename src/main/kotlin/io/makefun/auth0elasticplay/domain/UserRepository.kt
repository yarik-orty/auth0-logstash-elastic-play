package io.makefun.auth0elasticplay.domain

import io.makefun.auth0elasticplay.extensions.id
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class UserRepository(val jdbc: NamedParameterJdbcTemplate) {

    fun users(): List<User> {
        val query = "SELECT * FROM users;"
        return jdbc.query(query, emptyMap<String, String>(), BeanPropertyRowMapper(User::class.java))
    }

    fun findById(id: Int): User? {
        val query = "SELECT * FROM users WHERE id = :id;"
        return jdbc.queryForObject(query, mapOf("id" to id), BeanPropertyRowMapper(User::class.java))
    }

    fun create(user: User): Int {
        val query = "INSERT INTO users (email, name, password, role) VALUES(:email, :name, :password, :role);"
        val keyHolder = GeneratedKeyHolder()
        jdbc.update(query, BeanPropertySqlParameterSource(user), keyHolder)
        return keyHolder.id()
    }
}
