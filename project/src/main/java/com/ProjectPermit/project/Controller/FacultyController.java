package com.ProjectPermit.project.Controller;


import com.ProjectPermit.project.DTO.FacultyRegistrationDTO;
import com.ProjectPermit.project.Model.Faculty;
import com.ProjectPermit.project.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projectPermit")
public class FacultyController {
    @Autowired
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping("/facultyRegister")
    public ResponseEntity<String> registerFaculty(@RequestBody FacultyRegistrationDTO facultyRegistrationDTO){
        return facultyService.registerFaculty(facultyRegistrationDTO);
    }


}


