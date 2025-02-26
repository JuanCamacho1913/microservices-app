package com.student.presentation.dto;

public record StudentRequest(
        String name,
        String lastName,
        byte age,
        String email ) {
}
