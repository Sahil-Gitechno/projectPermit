package com.ProjectPermit.project.Repository;

import com.ProjectPermit.project.Model.GroupCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupCredentialsRepository extends JpaRepository<GroupCredentials, Long> {
    Optional<GroupCredentials> findByUsername(String username);
    // You can add custom query methods if needed

    
}
