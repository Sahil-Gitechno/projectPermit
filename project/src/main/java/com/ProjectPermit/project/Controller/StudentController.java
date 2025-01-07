package com.ProjectPermit.project.Controller;
import com.ProjectPermit.project.DTO.StudentGroupDTO;
import com.ProjectPermit.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/projectPermit/students")
    public class StudentController {

        @Autowired
        private StudentService studentService;

        // Register multiple students
        @PostMapping("/register")
        public ResponseEntity<String> registerStudents(@RequestBody List<StudentGroupDTO> studentDTOList) {
            try {
                studentService.registerStudents(studentDTOList);
                return new ResponseEntity<>("Students registered successfully", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error registering students", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


