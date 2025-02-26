package com.couse.presentation.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.UUID;

public record CourseResponse(
        UUID id,
        String name,
        String school,
        String city ) {
}
