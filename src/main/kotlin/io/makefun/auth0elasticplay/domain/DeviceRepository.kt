package io.makefun.auth0elasticplay.domain

import io.makefun.auth0elasticplay.extensions.id
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class DeviceRepository(val jdbc: NamedParameterJdbcTemplate) {

    fun devices(): List<Device> {
        val query = "SELECT * FROM devices;"
        return jdbc.query(query, emptyMap<String, String>(), BeanPropertyRowMapper(Device::class.java))
    }

    fun create(device: Device): Int {
        val query = "INSERT INTO devices (user_id, name, imei, serial_number, updated_at) VALUES(:userId, :name, :imei, :serialNumber, :updatedAt);"
        val keyHolder = GeneratedKeyHolder()
        jdbc.update(query, BeanPropertySqlParameterSource(device), keyHolder)
        return keyHolder.id()
    }
}
