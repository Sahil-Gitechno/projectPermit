package com.ProjectPermit.project.Model;

import jakarta.persistence.*;
import lombok.*;

    @Data
    @Entity
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long groupCode;

        private String firstName;
        private String lastName;
        private String rollNumber;
        private String mobileNumber;
        private String year;
        private String section;
        private String semester;
        private String department;

        @ManyToOne
        @JoinColumn(name = "groupCode" ,insertable = false, updatable = false)
        private Faculty faculty;
        private StudentGroup studentGroup;

        public Long getGroupCode() {
            return groupCode;
        }

        public void setGroupCode(Long groupCode) {
            this.groupCode = groupCode;
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

        public String getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Faculty getFaculty() {
            return faculty;
        }

        public void setFaculty(Faculty faculty) {
            this.faculty = faculty;
        }
    }



