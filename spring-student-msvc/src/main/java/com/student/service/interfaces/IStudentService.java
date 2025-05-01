package com.student.service.interfaces;

import com.common.student.StudentResponse;
import com.common.student.StudentBaseRequest;
import com.common.registration.RegistrationResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentService {

    List<StudentResponse> findAll();
    StudentResponse findById(UUID id);
    StudentResponse save(StudentBaseRequest studentRequest);
    RegistrationResponse saveAndRegister(StudentBaseRequest studentRequest, UUID courseId);
    StudentResponse update(StudentBaseRequest studentRequest, UUID id);
    String deleteId(UUID id);
}
