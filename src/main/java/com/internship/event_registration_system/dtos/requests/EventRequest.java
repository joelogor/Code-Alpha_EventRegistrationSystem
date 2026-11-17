package com.internship.event_registration_system.dtos.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class EventRequest {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Location is required")
    private String location;
    @Future
    @NotNull(message = "Event date required")
    private LocalDateTime eventDate;
    @NotNull(message = "Capacity field is required")
    @Positive(message = "Capacity must be greater than zero")
    private Integer capacity;
    @NotNull(message = "Duration hours field is required")
    @Positive(message = "Duration hours must be greater than zero")
    private Double durationHours;


}
