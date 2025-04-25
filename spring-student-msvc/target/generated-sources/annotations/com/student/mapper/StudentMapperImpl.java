package com.student.mapper;

import com.student.persistence.entity.Student;
import com.student.presentation.dto.StudentRequest;
import com.student.presentation.dto.StudentResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-29T15:03:20-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toStudent(StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.name( studentRequest.name() );
        student.lastName( studentRequest.lastName() );
        student.age( studentRequest.age() );
        student.email( studentRequest.email() );

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
