package com.ProjectPermit.project.Repository;

import com.ProjectPermit.project.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository <Faculty, Long> {
    Faculty findByEmailId(String emailId);

}
