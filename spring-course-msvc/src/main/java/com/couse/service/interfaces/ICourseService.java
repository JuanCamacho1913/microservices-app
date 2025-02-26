package com.couse.service.interfaces;

import com.couse.presentation.dto.CourseRequest;
import com.couse.presentation.dto.CourseResponse;

import java.util.List;
import java.util.UUID;

public interface ICourseService {

    List<CourseResponse> findAll();
    CourseResponse findById(UUID id);
    CourseResponse save(CourseRequest courseRequest);
    CourseResponse update(CourseRequest courseRequest, UUID id);
    String deleteId(UUID id);
}
