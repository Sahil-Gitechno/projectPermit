package com.ProjectPermit.project.Service;

import com.ProjectPermit.project.Model.Faculty;
import com.ProjectPermit.project.Model.Student;
import com.ProjectPermit.project.Model.StudentGroup;
import com.ProjectPermit.project.Repository.FacultyRepository;
import com.ProjectPermit.project.Repository.StudentGroupRepository;
import com.ProjectPermit.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    // AtomicInteger to maintain the last assigned faculty index in a thread-safe manner
    private final AtomicInteger lastAssignedFacultyIndex = new AtomicInteger(0);

    public void registerStudentGroup(List<Student> students, String groupCode) {
        // Get the faculty for the group using round-robin logic
        Faculty assignedFaculty = getRoundRobinAssignedFaculty();
        StudentGroup studentGroup = new StudentGroup();

        // Set the group code and the assigned faculty
        studentGroup.setGroupCode(groupCode);
        studentGroup.setFaculty(assignedFaculty);  // Link the faculty to the group

        // Save the group (which will also save the faculty reference)
        studentGroup = studentGroupRepository.save(studentGroup);

        // Now assign the student group to each student and save them
        for (Student student : students) {
            // Make sure each student is properly assigned the student group with the faculty
            student.setStudentGroup(studentGroup);  // Set the group reference
            studentRepository.save(student);  // Save student
        }
    }



    private Faculty getRoundRobinAssignedFaculty() {
        List<Faculty> faculties = facultyRepository.findAll();
        if (faculties.isEmpty()) {
            throw new IllegalStateException("No faculties available for assignment.");
        }

        // Get the next index in a round-robin manner
        int currentIndex = lastAssignedFacultyIndex.getAndUpdate(i -> (i + 1) % faculties.size());
        return faculties.get(currentIndex);
    }

  /*  public String getFacultyFromCode(String groupCode) {

        return facultyRepository.getFacultyFromCode(groupCode);
    }*/
}
