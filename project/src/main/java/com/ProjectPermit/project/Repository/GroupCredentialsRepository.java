package com.ProjectPermit.project.Repository;

import com.ProjectPermit.project.Model.GroupCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCredentialsRepository extends JpaRepository<GroupCredentials, Long> {
    // You can add custom query methods if needed
    GroupCredentials findByUsername(String username);
}
