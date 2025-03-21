package com.couse.presentation.dto;

import jakarta.persistence.Column;

import java.util.UUID;

public record RegistrationResponse(
        UUID idRegistration,
        UUID studentId,
        UUID courseId ) {
}
