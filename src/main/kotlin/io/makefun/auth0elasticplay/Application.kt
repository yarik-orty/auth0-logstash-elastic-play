package io.makefun.auth0elasticplay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// Kotlin, PostgreSQL, Logstash, ElasticSearch, Auth0
// Push data from PostgreSQL to ElasticSearch through Logstash for further processing/indexing + Auth0 auth

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
