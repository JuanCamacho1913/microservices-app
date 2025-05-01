package com.common.course;

import java.util.UUID;

public record CourseStudentRequest(
        UUID id,
        String name,
        String lastName,
        byte age,
        String email
) {
}
