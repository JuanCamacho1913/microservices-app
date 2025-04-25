package com.couse.mapper;

import com.couse.persistence.entity.Course;
import com.couse.presentation.dto.CourseRequest;
import com.couse.presentation.dto.CourseResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-29T15:03:39-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ICourseMapperImpl implements ICourseMapper {

    @Override
    public Course toCourse(CourseRequest courseRequest) {
        if ( courseRequest == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.name( courseRequest.name() );
        course.school( courseRequest.school() );
        course.city( courseRequest.city() );

        return course.build();
    }

    @Override
    public CourseResponse toCourseResponse(Course course) {
        if ( course == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String school = null;
        String city = null;

        id = course.getId();
        name = course.getName();
        school = course.getSchool();
        city = course.getCity();

        CourseResponse courseResponse = new CourseResponse( id, name, school, city );

        return courseResponse;
    }

    @Override
    public List<CourseResponse> toCourseResponseList(List<Course> courseList) {
        if ( courseList == null ) {
            return null;
        }

        List<CourseResponse> list = new ArrayList<CourseResponse>( courseList.size() );
        for ( Course course : courseList ) {
            list.add( toCourseResponse( course ) );
        }

        return list;
    }
}
