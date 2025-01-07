package com.ProjectPermit.project.Service;

import com.ProjectPermit.project.DTO.StudentGroupDTO;
import com.ProjectPermit.project.Model.Student;
import com.ProjectPermit.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save the student details into the database
    public void registerStudents(List<StudentGroupDTO> studentDTOList) {
        List<Student> students = new ArrayList<>();

        for (StudentGroupDTO studentDTO : studentDTOList) {
            Student student = new Student();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setRollNumber(studentDTO.getRollNumber());
            student.setMobileNumber(studentDTO.getMobileNumber());
            student.setYear(studentDTO.getYear());
            student.setSection(studentDTO.getSection());
            student.setSemester(studentDTO.getSemester());
            student.setDepartment(studentDTO.getDepartment());

            // finding the Faculty entity by the faculty code and set it here
            //facultyRepository.findByCode(studentDTO.getFacultyCode());

            students.add(student);
        }

        studentRepository.saveAll(students);
    }
}
