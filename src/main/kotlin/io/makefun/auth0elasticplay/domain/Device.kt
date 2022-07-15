package io.makefun.auth0elasticplay.domain

import io.makefun.auth0elasticplay.utils.NoArg
import java.time.LocalDateTime

@NoArg
data class Device(var id: Int = 0,
                  var userId: Int,
                  var name: String,
                  var imei: String,
                  var serial_number: String,
                  var updatedAt: LocalDateTime?,
                  var createdAt: LocalDateTime = LocalDateTime.now())
