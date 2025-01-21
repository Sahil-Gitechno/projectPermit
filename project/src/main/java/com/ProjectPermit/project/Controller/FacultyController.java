package com.ProjectPermit.project.Controller;


import com.ProjectPermit.project.DTO.FacultyLoginRequestDTO;
import com.ProjectPermit.project.DTO.FacultyRegistrationDTO;
import com.ProjectPermit.project.Model.Faculty;
import com.ProjectPermit.project.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/projectPermit")
public class FacultyController {
    @Autowired
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping("/facultyRegister")
    public ResponseEntity<Map<String, Object>> registerFaculty(@RequestBody FacultyRegistrationDTO facultyRegistrationDTO) {
        return facultyService.registerFaculty(facultyRegistrationDTO);
    }

    @PostMapping("facultyLogin")
    public ResponseEntity<Map<String,Object>>login(@RequestBody FacultyRegistrationDTO loginDTO) {
        boolean isAuthenticated = facultyService.authenticateFaculty(loginDTO.getEmailId(), loginDTO.getPassword());
        if (isAuthenticated) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("success", true);

            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login failed");
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
