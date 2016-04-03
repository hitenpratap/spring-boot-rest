package com.springBootDemo.event

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by hitenpratap on 02/04/16.
 */
@RestController
@RequestMapping(value = '/event')
class EventRestController {

    @Autowired
    EventRepository eventRepository

    @RequestMapping(method = RequestMethod.POST)
    public def create(@RequestBody Event event){
        Event newEvent = eventRepository.saveAndFlush(event)
        if(newEvent)
            [status:"Event created successfully."]
        else
            [status:"Something went wrong. Please try again."]
    }

    @RequestMapping(method = RequestMethod.DELETE,value = '{id}')
    public def delete(@PathVariable String id){
        eventRepository.delete(Long.parseLong(id))
        if(!eventRepository.exists(Long.parseLong(id)))
            [status:"Event deleted successfully."]
        else
            [status:"Something went wrong. Please try again."]
    }

    @RequestMapping(method = RequestMethod.GET)
    public def list(){
        List<Event> eventList = eventRepository.findAll()
        eventList
    }

    @RequestMapping(method = RequestMethod.GET,value = '{id}')
    public def get(@PathVariable String id){
        eventRepository.findOne(Long.parseLong(id))
    }

    @RequestMapping(method = RequestMethod.PUT,value = '{id}')
    public def update(@PathVariable String id,@RequestBody Event event){
        Event existingEvent = eventRepository.findOne(Long.parseLong(id))
        existingEvent.title = event.title
        existingEvent.description = event.description
        existingEvent.lastUpdated = new Date()
        if(eventRepository.saveAndFlush(existingEvent))
            [status:"Event updated successfully."]
        else
            [status:"Something went wrong. Please try again."]
    }

}
