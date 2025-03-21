package com.couse.persistence.repository;

import com.couse.persistence.entity.Registration;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRegistrationRepository extends ListCrudRepository<Registration, UUID> {

    Optional<Registration> findByCourseIdAndStudentId(UUID courseId, UUID studentId);
    List<Registration> findByCourseId(UUID courseId);
}
