package com.couse.service.implementation;

import com.couse.mapper.IRegistrationMapper;
import com.couse.persistence.entity.Registration;
import com.couse.persistence.repository.IRegistrationRepository;
import com.couse.presentation.dto.RegistrationResponse;
import com.couse.service.interfaces.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final IRegistrationRepository registrationRepository;
    private final IRegistrationMapper registrationMapper;

    @Override
    public RegistrationResponse registerStudent(UUID studentId, UUID courseId) {
        Registration registration = Registration.builder()
                .studentId(studentId)
                .courseId(courseId)
                .build();

        Registration registrationSaved = this.registrationRepository.save(registration);

        return this.registrationMapper.toRegistationResponse(registrationSaved);
    }

    @Override
    public RegistrationResponse findStudentByCourse(UUID studentId, UUID courseId) {
        Optional<Registration> registration =
                this.registrationRepository.findByCourseIdAndStudentId(courseId, studentId);

        if (!registration.isEmpty()){
            return this.registrationMapper.toRegistationResponse(registration.get());
        }

        return new RegistrationResponse(null, null, null);
    }

    @Override
    public List<RegistrationResponse> findAllStudentsByCourse(UUID courseId) {
       List<Registration> registrationList = this.registrationRepository.findByCourseId(courseId);

       if (!registrationList.isEmpty()){
           return this.registrationMapper.toRegistrationResponseList(registrationList);
       }

        return Collections.emptyList();
    }
}
