package com.student.service.implementation;

import com.student.exception.error.ElementNotFoundException;
import com.student.mapper.StudentMapper;
import com.student.persistence.entity.Student;
import com.student.persistence.repository.IStudentRepository;
import com.student.presentation.dto.RegistrationResponse;
import com.student.presentation.dto.StudentRequest;
import com.student.presentation.dto.StudentResponse;
import com.student.service.http.ICourseClient;
import com.student.service.interfaces.IStudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private static final String USER_NOT_FOUND_MESSAGE = "User whit id %s does not exist";

    private IStudentRepository studentRepository;
    private StudentMapper studentMapper;
    private ICourseClient courseClient;

    @Override
    public List<StudentResponse> findAll() {
        List<Student> studentList = this.studentRepository.findAll();
        return this.studentMapper.toStudentResponseList(studentList);
    }

    @Override
    public StudentResponse findById(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));
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
    public RegistrationResponse saveAndRegister(StudentRequest studentRequest, UUID courseId) {
        Student student = this.studentMapper.toStudent(studentRequest);
        student.setId(UUID.randomUUID());

        Student studentSaved = this.studentRepository.save(student);
        StudentResponse studentResponse = this.studentMapper.toStudentResponse(studentSaved);

        //Enviar peticion al microservicio course
        return this.courseClient.registerStudent(courseId, studentResponse);
    }

    @Override
    public StudentResponse update(StudentRequest studentRequest, UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));

        if (!StringUtils.isBlank(studentRequest.name())){
            student.setName(studentRequest.name());
        }

        if (!StringUtils.isBlank(studentRequest.lastName())){
            student.setLastName(studentRequest.lastName());
        }

        if (studentRequest.age() > 0){
            student.setAge(studentRequest.age());
        }

        if (!StringUtils.isBlank(studentRequest.email())){
            student.setEmail(studentRequest.email());
        }

        Student studentUpdated = this.studentRepository.save(student);

        return this.studentMapper.toStudentResponse(studentUpdated);
    }

    @Override
    public String deleteId(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));
        this.studentRepository.delete(student);
        return "User with id %s deleted successfuly";
    }
}
