package com.common.registration;

import java.util.UUID;

public record RegistrationResponse(
        UUID idRegistration,
        UUID studentId,
        UUID courseId ) {
}
