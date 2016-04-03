package com.springBootDemo.event

import com.fasterxml.jackson.annotation.JsonFormat

import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by hitenpratap on 02/04/16.
 */
@Entity
class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String title
    String description
    @JsonFormat(pattern="dd/MMM/yyyy")
    Date dateCreated = new Date()
    @JsonFormat(pattern="dd/MMM/yyyy")
    Date lastUpdated = new Date()

}
