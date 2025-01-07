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


@Service
public class FacultyService {

       @Autowired
       private  FacultyRepository facultyRepository;

        public ResponseEntity<String> registerFaculty (FacultyRegistrationDTO facultyDTO){
            // Checking if email already exists
            if (facultyRepository.findByEmailId(facultyDTO.getEmailId()) != null) {
                return new ResponseEntity<>("Email is already Registered",HttpStatus.ALREADY_REPORTED );
            }

            // Password and confirm password validation
            if (!facultyDTO.getPassword().equals(facultyDTO.getConfirmPassword())) {
                return new ResponseEntity<>("Passwords do not match", HttpStatus.NOT_ACCEPTABLE);
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

            return  ResponseEntity.ok("Faculty Registered Successfully");
        }
    }


