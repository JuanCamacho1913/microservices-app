package com.student.mapper;

import com.student.persistence.entity.Student;
import com.student.presentation.dto.StudentRequest;
import com.student.presentation.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toStudent(StudentRequest studentRequest);
    StudentResponse toStudentResponse(Student student);

    List<StudentResponse> toStudentResponseList(List<Student> studentList);
}
