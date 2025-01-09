package com.ProjectPermit.project.Service;

import com.ProjectPermit.project.Model.GroupCredentials;
import com.ProjectPermit.project.Model.StudentGroup;
import com.ProjectPermit.project.Repository.GroupCredentialsRepository;
import com.ProjectPermit.project.Repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupCredentialsService {

    @Autowired
    private GroupCredentialsRepository groupCredentialsRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    public GroupCredentials createGroupCredentials(Long groupId, String username, String password) {
        Optional<StudentGroup> studentGroupOptional = studentGroupRepository.findById(groupId);
        if (studentGroupOptional.isPresent()) {
            StudentGroup studentGroup = studentGroupOptional.get();

            GroupCredentials credentials = new GroupCredentials();
            credentials.setUsername(username);
            credentials.setPassword(password);
            credentials.setStudentGroup(studentGroup);

            return groupCredentialsRepository.save(credentials);
        } else {
            throw new RuntimeException("Student Group not found with ID: " + groupId);
        }
    }

    public GroupCredentials getGroupCredentialsByGroupId(Long groupId) {
        return groupCredentialsRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Credentials not found for Group ID: " + groupId));
    }
}
