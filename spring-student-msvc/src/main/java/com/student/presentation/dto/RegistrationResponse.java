package com.student.presentation.dto;

import java.util.UUID;

public record RegistrationResponse(
        UUID idRegistration,
        UUID studentId,
        UUID courseId ) {
}
