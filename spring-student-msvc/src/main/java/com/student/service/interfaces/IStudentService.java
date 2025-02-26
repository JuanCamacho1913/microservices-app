package com.student.service.interfaces;

import com.student.presentation.dto.StudentRequest;
import com.student.presentation.dto.StudentResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentService {

    List<StudentResponse> findAll();
    StudentResponse findById(UUID id);
    StudentResponse save(StudentRequest studentRequest);
    StudentResponse update(StudentRequest studentRequest, UUID id);
    String deleteId(UUID id);
}
