package com.ProjectPermit.project.Controller;

import com.ProjectPermit.project.Model.Student;
import com.ProjectPermit.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectPermit/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/registerGroup")
    public ResponseEntity<String> registerStudentGroup(@RequestBody List<Student> students,
                                                       @RequestParam String groupCode) {
        studentService.registerStudentGroup(students, groupCode);
        return ResponseEntity.ok("Student group registered successfully with Faculty linked");
    }
}
