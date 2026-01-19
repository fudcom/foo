package com.dynatrace.vast.playground.messages

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "messages")
//@Table(name = "messages", indexes = [Index(name = "idx_customers_email", columnList = "email", unique = true)])
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @NotBlank
    var payload: String? = null

    protected constructor() // JPA

    constructor(payload: String?) {
        this.payload = payload
    }
}
