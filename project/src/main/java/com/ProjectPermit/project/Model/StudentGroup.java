package com.ProjectPermit.project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "student_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(unique = true, nullable = false)
    private String groupCode;

    // The correct mapping for the relationship between StudentGroup and Faculty
    @ManyToOne
    @JoinColumn(name = "faculty_code", nullable = false)  // 'faculty_code' is the FK column in the 'student_group' table
    private Faculty faculty;  // This references the whole Faculty entity, not just the 'Long' facultyCode

    @OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL)
    private List<Student> students;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

