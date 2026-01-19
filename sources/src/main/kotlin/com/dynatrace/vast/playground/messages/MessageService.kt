package com.dynatrace.vast.playground.messages

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MessageService(private val repo: MessageRepository) {

    @Transactional(readOnly = true)
    fun findAll(): MutableList<Message?> {
        return repo.findAll()
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Message? {
        return repo.findById(id)
            .orElseThrow({ IllegalArgumentException("Message not found: " + id) })
    }

    @Transactional
    fun create(c: Message): Message {
        return repo.save(c)
    }

    @Transactional
    fun update(id: Long, update: Message): Message {
        return findById(id)?.also {
            it.payload = update.payload
            repo.save(it)
        } ?: run {
            repo.save(update)
        }
    }

    @Transactional
    fun delete(id: Long) {
        repo.deleteById(id)
    }
}
