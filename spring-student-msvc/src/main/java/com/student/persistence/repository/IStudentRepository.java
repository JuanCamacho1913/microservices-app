package com.student.persistence.repository;

import com.student.persistence.entity.Student;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStudentRepository extends ListCrudRepository<Student, UUID> {
}
