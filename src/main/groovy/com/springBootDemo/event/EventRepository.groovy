package com.springBootDemo.event

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by hitenpratap on 02/04/16.
 */
interface EventRepository extends JpaRepository<Event,Long>{

    void delete(Long id);

    List<Event> findAll();

    Event findOne(Long id);

    Event saveAndFlush(Event event);

    boolean exists(Long id);

}
