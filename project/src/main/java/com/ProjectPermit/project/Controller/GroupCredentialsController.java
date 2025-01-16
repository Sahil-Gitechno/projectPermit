package com.ProjectPermit.project.Controller;

import com.ProjectPermit.project.Service.GroupCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/projectPermit/groups")
public class GroupCredentialsController {

    @Autowired
    private GroupCredentialsService groupCredentialsService;

    @PostMapping("/createCredentials")
    public ResponseEntity<Map<String, String>> createGroupCredentials(@RequestBody GroupCredentialsRequest request) {
        groupCredentialsService.createGroupCredentials(request.getGroupId(), request.getUsername(), request.getPassword(), request.getConfirmPassword());

        // Create a response body map
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "Credentials created successfully for group " + request.getGroupId());
        responseBody.put("groupId", String.valueOf(request.getGroupId()));
        responseBody.put("username", request.getUsername());
        responseBody.put("password", request.getPassword());
        responseBody.put("confrimPassword", request.getConfirmPassword());
        return ResponseEntity.ok(responseBody);
    }

    // Create a DTO for the request body
    public static class GroupCredentialsRequest {
        private Long groupId;
        private String username;
        private String password;
        private String confirmPassword;
        // Getters and setters

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
