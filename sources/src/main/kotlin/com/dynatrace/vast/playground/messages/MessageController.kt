package com.dynatrace.vast.playground.messages

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/messages")
class MessageController(service: MessageService) {
    private val service: MessageService

    init {
        this.service = service
    }

    @GetMapping
    fun all(): List<Message?> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: Long): Message? {
        return service.findById(id)
    }

    @PostMapping
    fun create(@Valid @RequestBody payload: @Valid Message): ResponseEntity<Message> {
        val created: Message = service.create(payload)
        return ResponseEntity.created(URI.create("/messages/" + created.id)).body<Message>(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody payload: @Valid Message): Message {
        return service.update(id, payload)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build<Void>()
    }
}
