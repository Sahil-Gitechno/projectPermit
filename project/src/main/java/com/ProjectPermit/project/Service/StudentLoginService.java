package com.ProjectPermit.project.Service;

import com.ProjectPermit.project.Model.GroupCredentials;
import com.ProjectPermit.project.Repository.GroupCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentLoginService {
    @Autowired
    GroupCredentialsRepository groupCredentialsRepository;




    public boolean authenticateGroup(String username, String password) {
        Optional<GroupCredentials> credentials = groupCredentialsRepository.findByUsername(username);
        return credentials.isPresent() && credentials.get().getPassword().equals(password);
    }
}
