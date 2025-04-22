package com.couse.presentation.dto;

import java.util.UUID;

public record StudentRequest(
        UUID id,
        String name,
        String lastName,
        byte age,
        String email
) {
}
