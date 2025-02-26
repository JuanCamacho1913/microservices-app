package com.couse.persistence.repository;

import com.couse.persistence.entity.Course;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICourseRepository extends ListCrudRepository<Course, UUID> {
}
