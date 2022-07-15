package io.makefun.auth0elasticplay.domain

import io.makefun.auth0elasticplay.utils.NoArg
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.time.LocalDateTime

@NoArg
data class User(var id: Int = 0,
                var email: String,
                var name: String,
                var password: String,
                var role: String,
                var createdAt: LocalDateTime = LocalDateTime.now())

@NoArg
@Document(indexName = "users")
data class UserEntity(
        @Id
        var id: Int?,
        var email: String?,
        var name: String?,
        var password: String?,
        var role: String?,
        var createdAt: LocalDateTime?
)