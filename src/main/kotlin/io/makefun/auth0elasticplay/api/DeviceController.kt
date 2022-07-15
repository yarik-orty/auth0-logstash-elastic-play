package io.makefun.auth0elasticplay.api

import io.makefun.auth0elasticplay.domain.Device
import io.makefun.auth0elasticplay.domain.DeviceRepository
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/devices")
class DeviceController(private val repository: DeviceRepository) {

    @GetMapping
    fun devices(): List<Device> {
        return repository.devices()
    }

    @PostMapping
    fun create(@RequestBody device: Device) {
        repository.create(device)
    }
}

// https://medium.com/@emreceylan/how-to-sync-postgresql-data-to-elasticsearch-572af15845ad
// https://github.com/dimMaryanto93/docker-logstash-input-jdbc
// https://harshityadav95.medium.com/getting-started-with-logstash-96f5f1000cb6