package com.ProjectPermit.project.Repository;

import com.ProjectPermit.project.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
