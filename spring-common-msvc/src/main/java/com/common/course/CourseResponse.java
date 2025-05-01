package com.common.course;

import java.util.UUID;

public record CourseResponse(
        UUID id,
        String name,
        String school,
        String city ) {
}
