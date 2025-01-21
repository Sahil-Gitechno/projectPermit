package com.ProjectPermit.project.Controller;
import com.ProjectPermit.project.Model.Student;
import com.ProjectPermit.project.Model.StudentGroup;
import com.ProjectPermit.project.Service.GroupCredentialsService;
import com.ProjectPermit.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectPermit/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupCredentialsService groupCredentialsService;



    @PostMapping("/registerGroup")
    public ResponseEntity<Map<String, Object>> registerStudentGroup(@RequestBody Map<String, List<Student>> requestBody,
                                                                    @RequestParam String groupCode) {
        List<Student> students = requestBody.get("students");

        // Call the service method
        studentService.registerStudentGroup(students, groupCode);

        // After saving, fetch the groupId by querying the group based on groupCode
        StudentGroup stdGroup = studentService.findByGroupCode(groupCode);
        Long groupId = stdGroup.getGroupId();

        // Prepare the response body
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("success", true);
        responseBody.put("groupId", groupId);

        // Return the JSON response
        return ResponseEntity.ok(responseBody);
    }




}
