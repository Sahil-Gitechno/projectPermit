package com.ProjectPermit.project.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupCode; // This will be the unique code for the group
}
