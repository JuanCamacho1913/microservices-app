package com.couse.service.implementation;

import com.couse.exception.error.ElementNotFoundException;
import com.couse.mapper.ICourseMapper;
import com.couse.persistence.entity.Course;
import com.couse.persistence.repository.ICourseRepository;
import com.couse.presentation.dto.CourseRequest;
import com.couse.presentation.dto.CourseResponse;
import com.couse.service.interfaces.ICourseService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private static final String USER_NOT_FOUND_MESSAGE = "User whit id %s does not exist";

    private ICourseRepository courseRepository;
    private ICourseMapper courseMapper;

    @Override
    public List<CourseResponse> findAll() {
        List<Course> courseList = this.courseRepository.findAll();

        return this.courseMapper.toCourseResponseList(courseList);
    }

    @Override
    public CourseResponse findById(UUID id) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));

        return this.courseMapper.toCourseResponse(course);
    }

    @Override
    public CourseResponse save(CourseRequest courseRequest) {
        Course course = this.courseMapper.toCourse(courseRequest);
        course.setId(UUID.randomUUID());
        Course courseSaved =this.courseRepository.save(course);

        return this.courseMapper.toCourseResponse(courseSaved);
    }

    @Override
    public CourseResponse update(CourseRequest courseRequest, UUID id) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));

        if (!StringUtils.isBlank(courseRequest.name())){
            course.setName(courseRequest.name());
        }

        if (!StringUtils.isBlank(courseRequest.school())){
            course.setSchool(courseRequest.school());
        }

        if (!StringUtils.isBlank(courseRequest.city())){
            course.setCity(courseRequest.city());
        }

        Course courseUpdated = this.courseRepository.save(course);

        return this.courseMapper.toCourseResponse(courseUpdated);
    }

    @Override
    public String deleteById(UUID id) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));
        this.courseRepository.delete(course);

        return "User with id %s deleted successfuly";
    }
}
