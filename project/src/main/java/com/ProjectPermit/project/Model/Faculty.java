package com.ProjectPermit.project.Model;
import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Faculty {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long facultyCode;

        private String firstName;
        private String lastName;
        private String emailId;
        private String mobileNumber;
        private String password;

    public Long getFacultyCode() {
        return facultyCode;
    }

    public void setId(Long facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
