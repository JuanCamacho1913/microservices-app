package com.couse.service.interfaces;

import com.couse.presentation.dto.RegistrationResponse;

import java.util.List;
import java.util.UUID;

public interface IRegistrationService {

    RegistrationResponse registerStudent(UUID studentId, UUID courseId);
    RegistrationResponse findStudentByCourse(UUID studentId, UUID courseId);
    List<RegistrationResponse> findAllStudentsByCourse(UUID courseId);
}
