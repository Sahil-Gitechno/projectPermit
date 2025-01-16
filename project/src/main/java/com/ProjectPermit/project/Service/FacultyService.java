package com.ProjectPermit.project.Service;

import com.ProjectPermit.project.DTO.FacultyRegistrationDTO;
import com.ProjectPermit.project.Model.Faculty;
import com.ProjectPermit.project.Repository.FacultyRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class FacultyService {

       @Autowired
       private  FacultyRepository facultyRepository;

    public ResponseEntity<Map<String, Object>> registerFaculty(FacultyRegistrationDTO facultyDTO) {
        Map<String, Object> response = new HashMap<>();

        // Checking if email already exists
        if (facultyRepository.findByEmailId(facultyDTO.getEmailId()) != null) {
            response.put("message", "Email is already registered.");
            response.put("success", false);
            return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
        }

        // Password and confirm password validation
        if (!facultyDTO.getPassword().equals(facultyDTO.getConfirmPassword())) {
            response.put("message", "Passwords do not match.");
            response.put("success", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        // Creating Faculty object from DTO
        Faculty faculty = new Faculty();
        faculty.setFirstName(facultyDTO.getFirstName());
        faculty.setLastName(facultyDTO.getLastName());
        faculty.setEmailId(facultyDTO.getEmailId());
        faculty.setMobileNumber(facultyDTO.getMobileNumber());
        faculty.setPassword(facultyDTO.getPassword());

        // Save faculty to the database
        facultyRepository.save(faculty);

        // Returning success response
        response.put("message", "Faculty registered successfully.");
        response.put("success", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public boolean authenticateFaculty(String emailId, String password) {
        Faculty faculty = facultyRepository.findByEmailId(emailId);
        if (faculty != null && faculty.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    }


