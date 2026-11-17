package com.internship.event_registration_system.repositories;

import com.internship.event_registration_system.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {


}
