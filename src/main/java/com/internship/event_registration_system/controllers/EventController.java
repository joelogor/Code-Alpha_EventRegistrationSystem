package com.internship.event_registration_system.controllers;

import com.internship.event_registration_system.dtos.requests.EventRequest;
import com.internship.event_registration_system.dtos.responses.EventResponse;
import com.internship.event_registration_system.models.Event;
import com.internship.event_registration_system.services.EventService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService ;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<EventResponse> createEvent(
            @Valid @RequestBody EventRequest request) {

        EventResponse response = eventService.createEvent(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
     @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents( ){
        List<EventResponse> responses =  eventService.getAllEvents();

        return ResponseEntity.status(HttpStatus.OK).body(responses);

     }
     @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(
            @PathVariable Long id) {
         EventResponse response = eventService.getEventById(id);

         return ResponseEntity.ok(response);

     }
    @PutMapping ("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequest request){
        EventResponse response = eventService.updateEvent(id,request);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){

         eventService.deleteEventById(id);

        return ResponseEntity.noContent().build();

    }


}
