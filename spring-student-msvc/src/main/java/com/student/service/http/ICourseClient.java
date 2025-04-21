package com.student.service.http;


import com.student.presentation.dto.RegistrationResponse;
import com.student.presentation.dto.StudentRequest;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.UUID;

@FeignClient(name = "SPRING-COURSE")
public interface CourseClient {

    RegistrationResponse registerStudent(UUID courseId, StudentRequest studentRequest);
}
