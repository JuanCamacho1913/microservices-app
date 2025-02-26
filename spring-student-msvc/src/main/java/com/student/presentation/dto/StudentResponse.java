package com.student.presentation.dto;

import java.util.UUID;

public record StudentResponse(
        UUID id,
        String name,
        String lastName,
        byte age,
        String email ) {

}
