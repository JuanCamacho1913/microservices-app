package com.couse.mapper;

import com.couse.persistence.entity.Course;
import com.couse.presentation.dto.CourseRequest;
import com.couse.presentation.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICourseMapper {

    ICourseMapper INSTANCE = Mappers.getMapper(ICourseMapper.class);

    Course toCourse(CourseRequest courseRequest);
    CourseResponse toCourseResponse(Course course);
    Course toUpdateCourse(CourseRequest courseRequest, Course course);

    List<CourseResponse> toCourseResponseList(List<Course> courseList);
}
