package com.common.student;

public record StudentBaseRequest(
        String name,
        String lastName,
        byte age,
        String email ) {
}
