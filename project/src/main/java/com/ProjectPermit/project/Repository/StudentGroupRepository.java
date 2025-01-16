package com.ProjectPermit.project.Repository;

import com.ProjectPermit.project.Model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    StudentGroup findByGroupCode(String groupCode);

   // Optional<StudentGroup> findByUsername(String username);
}
