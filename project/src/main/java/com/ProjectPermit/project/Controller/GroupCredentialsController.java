package com.ProjectPermit.project.Controller;

import com.ProjectPermit.project.Service.GroupCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projectPermit/groups")
public class GroupCredentialsController {

    @Autowired
    private GroupCredentialsService groupCredentialsService;

    @PostMapping("/createCredentials")
    public ResponseEntity<String> createGroupCredentials(@RequestBody GroupCredentialsRequest request) {
        groupCredentialsService.createGroupCredentials(request.getGroupId(), request.getUsername(), request.getPassword());
        return ResponseEntity.ok("Credentials created successfully for group " + request.getGroupId());
    }

    // Create a DTO for the request body
    public static class GroupCredentialsRequest {
        private Long groupId;
        private String username;
        private String password;

        // Getters and setters

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
