package com.ProjectPermit.project.Repository;

import com.ProjectPermit.project.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    Faculty findByEmailId(String emailId);

    /*Faculty findByFacultyCode(Long facultyCode);
    @Query(nativeQuery = true,value = "Select CONCAT(firstname," ",lastName) from faculty where facultyc")
    String getFacultyFromCode();
*/
}

