package com.dynatrace.vast.playground.messages

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MessageRepository : JpaRepository<Message, Long> {
}
