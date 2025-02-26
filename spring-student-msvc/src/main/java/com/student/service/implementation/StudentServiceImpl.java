package com.student.service.implementation;

import com.student.exception.error.ElementNotFoundException;
import com.student.mapper.StudentMapper;
import com.student.persistence.entity.Student;
import com.student.persistence.repository.IStudentRepository;
import com.student.presentation.dto.StudentRequest;
import com.student.presentation.dto.StudentResponse;
import com.student.service.interfaces.IStudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private IStudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public List<StudentResponse> findAll() {
        List<Student> studentList = this.studentRepository.findAll();
        return this.studentMapper.toStudentResponseList(studentList);
    }

    @Override
    public StudentResponse findById(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("User whit id %s does not exist", id)));
        return this.studentMapper.toStudentResponse(student);
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = this.studentMapper.toStudent(studentRequest);
        student.setId(UUID.randomUUID());
        Student studentSaved = this.studentRepository.save(student);

        return this.studentMapper.toStudentResponse(studentSaved);
    }

    @Override
    public StudentResponse update(StudentRequest studentRequest, UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("User whit id %s does not exist", id)));
        Student studentForUpdate = this.studentMapper.toUpdateStudent(studentRequest, student);
        Student studentUpdate = this.studentRepository.save(studentForUpdate);
        return this.studentMapper.toStudentResponse(studentUpdate);
    }

    @Override
    public String deleteId(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("User whit id %s does not exist", id)));
        this.studentRepository.delete(student);
        return "User with id %s deleted successfuly";
    }
}
