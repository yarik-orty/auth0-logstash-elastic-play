package io.makefun.auth0elasticplay.extensions

import org.springframework.jdbc.support.GeneratedKeyHolder

fun GeneratedKeyHolder.id(): Int {
    val id = this.keys?.get("id") ?: throw IllegalStateException("KeyHolder 'id' could not be null")
    return id.toString().toInt()
}
