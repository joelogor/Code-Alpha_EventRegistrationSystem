package com.internship.event_registration_system.services;

import com.internship.event_registration_system.dtos.requests.EventRequest;
import com.internship.event_registration_system.dtos.responses.EventResponse;
import com.internship.event_registration_system.exceptions.EventNotFoundException;
import com.internship.event_registration_system.models.Event;
import com.internship.event_registration_system.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventResponse createEvent(EventRequest request) {
        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setCapacity(request.getCapacity());
        event.setEventDate(request.getEventDate());
        event.setDurationHours(request.getDurationHours());
        event.setLocation(request.getLocation());

        Event savedEvent = eventRepository.save(event);
        EventResponse response = new EventResponse();
        response.setId(savedEvent.getId());
        response.setDescription(savedEvent.getDescription());
        response.setTitle(savedEvent.getTitle());
        response.setCapacity(savedEvent.getCapacity());
        response.setDurationHours(savedEvent.getDurationHours());
        response.setEventDate(savedEvent.getEventDate());
        response.setLocation(savedEvent.getLocation());

        return response;
    }
    public List<EventResponse> getAllEvents(){
        List<EventResponse> responses = new ArrayList<>();

        List<Event> events = eventRepository.findAll();

        for (Event event : events) {

            EventResponse response = new EventResponse();

            response.setId(event.getId());
            response.setTitle(event.getTitle());
            response.setDescription(event.getDescription());
            response.setLocation(event.getLocation());
            response.setEventDate(event.getEventDate());
            response.setCapacity(event.getCapacity());
            response.setDurationHours(event.getDurationHours());

            responses.add(response);
        }

      return responses;

    }

    public EventResponse getEventById(Long id) throws EventNotFoundException {
        Optional<Event> event = eventRepository.findById(id)
;
        if (event.isPresent()) {
            EventResponse response = new EventResponse();
            Event eventFound = event.get();
            response.setId(eventFound.getId());
            response.setTitle(eventFound.getTitle());
            response.setDescription(eventFound.getDescription());
            response.setLocation(eventFound.getLocation());
            response.setEventDate(eventFound.getEventDate());
            response.setCapacity(eventFound.getCapacity());
            response.setDurationHours(eventFound.getDurationHours());

            return response;

        }else {
                throw new EventNotFoundException("Event not found");

            }

    }
    public EventResponse updateEvent(Long id, EventRequest request) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event existingEvent = event.get();
            existingEvent.setTitle(request.getTitle());
            existingEvent.setDescription(request.getDescription());
            existingEvent.setEventDate(request.getEventDate());
            existingEvent.setLocation(request.getLocation());
            existingEvent.setCapacity(request.getCapacity());
            existingEvent.setDurationHours(request.getDurationHours());

            Event updatedEvent = eventRepository.save(existingEvent);

            EventResponse response = new EventResponse();
            response.setTitle(updatedEvent.getTitle());
            response.setDescription(updatedEvent.getDescription());
            response.setLocation(updatedEvent.getLocation());
            response.setDurationHours(updatedEvent.getDurationHours());
            response.setCapacity(updatedEvent.getCapacity());
            response.setEventDate(updatedEvent.getEventDate());
            response.setId(updatedEvent.getId());

            return response;
        }


               else {
                   throw new EventNotFoundException("Event Not Found");
        }
    }
    public void deleteEventById(Long id){
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()){
            Event foundEvent = event.get();
            eventRepository.delete(foundEvent);
        }
        else{
            throw new EventNotFoundException("Event Not Found");
        }
    }




}
