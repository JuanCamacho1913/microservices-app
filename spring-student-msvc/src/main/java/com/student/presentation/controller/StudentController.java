package com.student.presentation.controller;

import com.student.presentation.dto.RegistrationResponse;
import com.student.presentation.dto.StudentRequest;
import com.student.presentation.dto.StudentResponse;
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
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequest studentRequest){
        StudentResponse studentResponse = this.studentService.save(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @PostMapping("/create/register")
    public ResponseEntity<RegistrationResponse> saveAndRegister(@RequestBody StudentRequest studentRequest,
                                                                @RequestParam UUID courseId){
        RegistrationResponse registrationResponse = this.studentService.saveAndRegister(studentRequest, courseId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponse> update(@RequestBody StudentRequest studentRequest, @PathVariable UUID id){
        StudentResponse studentResponse = this.studentService.update(studentRequest, id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteId(@PathVariable UUID id){
        String result = this.studentService.deleteId(id);
        return ResponseEntity.ok(result);
    }

}
