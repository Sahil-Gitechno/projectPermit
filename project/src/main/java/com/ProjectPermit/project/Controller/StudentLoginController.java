package com.ProjectPermit.project.Controller;

import com.ProjectPermit.project.DTO.StudentLoginDTO;
import com.ProjectPermit.project.Service.StudentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/projectPermit")
public class StudentLoginController {


    @Autowired
    StudentLoginService studentLoginService;
    @PostMapping("/studentLogin")
    public ResponseEntity<Map<String, Object>> login(@RequestBody StudentLoginDTO login) {
        boolean isAuthenticated = studentLoginService.authenticateGroup(login.getUsername(), login.getPassword());

        Map<String, Object> response = new HashMap<>();
        if (isAuthenticated) {
            response.put("message", "Login successful");
            response.put("status", "success");
        } else {
            response.put("message", "Invalid username or password");
            response.put("status", "error");
        }

        return ResponseEntity.ok(response);
    }

}
