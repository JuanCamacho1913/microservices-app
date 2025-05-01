package com.student.presentation.controller;

import com.common.registration.RegistrationResponse;
import com.common.student.StudentBaseRequest;
import com.common.student.StudentResponse;
import com.student.service.interfaces.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private IStudentService studentService;

    @GetMapping("/findAll")
    public ResponseEntity<List<StudentResponse>> findAllStudent(){
        List<StudentResponse> studentResponses = this.studentService.findAll();
        return new ResponseEntity<>(studentResponses, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable UUID id){
        StudentResponse studentResponse = this.studentService.findById(id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponse> save(@RequestBody StudentBaseRequest studentBaseRequest){
        StudentResponse studentResponse = this.studentService.save(studentBaseRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @PostMapping("/create/register")
    public ResponseEntity<RegistrationResponse> saveAndRegister(@RequestBody StudentBaseRequest studentBaseRequest,
                                                                @RequestParam UUID courseId){
        RegistrationResponse registrationResponse = this.studentService.saveAndRegister(studentBaseRequest, courseId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponse> update(@RequestBody StudentBaseRequest studentBaseRequest, @PathVariable UUID id){
        StudentResponse studentResponse = this.studentService.update(studentBaseRequest, id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteId(@PathVariable UUID id){
        String result = this.studentService.deleteId(id);
        return ResponseEntity.ok(result);
    }

}
