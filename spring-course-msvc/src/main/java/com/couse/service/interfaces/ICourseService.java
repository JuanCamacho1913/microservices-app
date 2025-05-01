package com.couse.service.interfaces;

import com.common.course.CourseRequest;
import com.common.course.CourseResponse;

import java.util.List;
import java.util.UUID;

public interface ICourseService {

    List<CourseResponse> findAll();
    CourseResponse findById(UUID id);
    CourseResponse save(CourseRequest courseRequest);
    CourseResponse update(CourseRequest courseRequest, UUID id);
    String deleteById(UUID id);
}
