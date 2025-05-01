package com.student.service.http;


import com.common.registration.RegistrationResponse;
import com.common.student.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "SPRING-COURSE")
public interface ICourseClient {

    @PostMapping("/courses/{courseId}/register")
    RegistrationResponse registerStudent(@PathVariable UUID courseId, @RequestBody StudentResponse studentResponse);
}
