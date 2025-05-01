package com.couse.presentation.controller;

import com.common.course.CourseRequest;
import com.common.course.CourseResponse;
import com.common.course.CourseStudentRequest;
import com.common.registration.RegistrationResponse;
import com.couse.service.interfaces.ICourseService;
import com.couse.service.interfaces.IRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private ICourseService courseService;
    private IRegistrationService registrationService;

    @GetMapping("/findAll")
    public ResponseEntity<List<CourseResponse>> findAll(){
        List<CourseResponse> courseResponseList = this.courseService.findAll();
        return new ResponseEntity<>(courseResponseList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable UUID id){
        CourseResponse courseResponse = this.courseService.findById(id);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponse> save(@RequestBody CourseRequest courseRequest){
        CourseResponse courseResponse = this.courseService.save(courseRequest);
        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponse> update(@RequestBody CourseRequest courseRequest,@PathVariable UUID id){
        CourseResponse courseResponse = this.courseService.update(courseRequest, id);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteId(@PathVariable UUID id){
        String result = this.courseService.deleteById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerStudent(@RequestParam UUID courseId,
                                                                @RequestBody CourseStudentRequest courseStudentRequest){
        CourseResponse courseResponse = this.courseService.findById(courseId);
        RegistrationResponse registrationResponse = this.registrationService.registerStudent(courseStudentRequest.id(), courseResponse.id());

        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }

}
