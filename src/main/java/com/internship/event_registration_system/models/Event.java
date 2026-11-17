package com.internship.event_registration_system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Event title is required")
    private String title;
    @NotBlank(message = "Event description is required")
    private String description;
    @NotBlank(message = "Event location is required")
    private String location;
    @NotNull(message = "Event date is required")
    private LocalDateTime eventDate;
    @Positive(message = "Capacity must be greater than zero")
    private Integer capacity;
    @Positive(message = "Duration time must be greater than zero")
    private Double durationHours;

}
