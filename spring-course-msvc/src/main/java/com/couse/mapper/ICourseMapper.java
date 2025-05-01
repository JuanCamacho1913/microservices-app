package com.couse.mapper;

import com.common.course.CourseRequest;
import com.common.course.CourseResponse;
import com.couse.persistence.entity.Course;
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

    List<CourseResponse> toCourseResponseList(List<Course> courseList);
}
