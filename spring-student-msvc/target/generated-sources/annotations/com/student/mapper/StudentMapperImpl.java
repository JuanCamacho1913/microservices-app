package com.student.mapper;

import com.common.student.StudentBaseRequest;
import com.common.student.StudentResponse;
import com.student.persistence.entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T23:11:47-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toStudent(StudentBaseRequest studentBaseRequest) {
        if ( studentBaseRequest == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.name( studentBaseRequest.name() );
        student.lastName( studentBaseRequest.lastName() );
        student.age( studentBaseRequest.age() );
        student.email( studentBaseRequest.email() );

        return student.build();
    }

    @Override
    public StudentResponse toStudentResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String lastName = null;
        byte age = 0;
        String email = null;

        id = student.getId();
        name = student.getName();
        lastName = student.getLastName();
        age = student.getAge();
        email = student.getEmail();

        StudentResponse studentResponse = new StudentResponse( id, name, lastName, age, email );

        return studentResponse;
    }

    @Override
    public List<StudentResponse> toStudentResponseList(List<Student> studentList) {
        if ( studentList == null ) {
            return null;
        }

        List<StudentResponse> list = new ArrayList<StudentResponse>( studentList.size() );
        for ( Student student : studentList ) {
            list.add( toStudentResponse( student ) );
        }

        return list;
    }
}
