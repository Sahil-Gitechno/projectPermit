package com.ProjectPermit.project.Controller;
import com.ProjectPermit.project.Model.Student;
import com.ProjectPermit.project.Model.StudentGroup;
import com.ProjectPermit.project.Service.GroupCredentialsService;
import com.ProjectPermit.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projectPermit/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupCredentialsService groupCredentialsService;

    @PostMapping("/registerGroup")

    public ResponseEntity<String> registerStudentGroup(@RequestBody Map<String, List<Student>> requestBody,
                                                       @RequestParam String groupCode) {
        List<Student> students = requestBody.get("students");

        // Call the service method
        studentService.registerStudentGroup(students, groupCode);

        // After saving, fetch the groupId by querying the group based on groupCode
        StudentGroup stdGroup = studentService.findByGroupCode(groupCode);
        System.out.println("Group ID: " + stdGroup.getGroupId());

        // Return the response with groupId
        return ResponseEntity.ok("Student group registered successfully. Please proceed to /projectPermit/groups/createCredentials ans Enter the groupId as " + stdGroup.getGroupId() + " to create credentials.");
    }


}
