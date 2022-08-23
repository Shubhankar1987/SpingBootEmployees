package com.example.model;


import com.example.util.EmployeeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EMPLOYEES")
public class Employees {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        @Column(name = "ID")
        private Long id;

        @Column(name = "EMP_NAME")
        private String empName;

        //@JsonIgnore
        @Column(name = "PASSWORD")
        private String password;

        @Temporal(value = TemporalType.TIMESTAMP)
        @Column(name = "CREATED_TIME")
        private Date creationTime;

        @Temporal(value = TemporalType.TIMESTAMP)
        @Column(name = "UPDATED_TIME")
        private Date updatedTime;

        @Temporal(value = TemporalType.DATE)
        @Column(name = "DOB")
        private Date dateofBirth;

        @Enumerated(value = EnumType.STRING)
        @Column(name = "EMP_TYPE")
        private EmployeeType empType;

        @Transient
        private String dateOfBirthString;

        // Setters and Getters

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getEmpName() {
                return empName;
        }

        public void setEmpName(String empName) {
                this.empName = empName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Date getCreationTime() {
                return creationTime;
        }

        public void setCreationTime(Date creationTime) {
                this.creationTime = creationTime;
        }

        public Date getUpdatedTime() {
                return updatedTime;
        }

        public void setUpdatedTime(Date updatedTime) {
                this.updatedTime = updatedTime;
        }

        public Date getDateofBirth() {
                return dateofBirth;
        }

        public void setDateofBirth(Date dateofBirth) {
                this.dateofBirth = dateofBirth;
        }

        public EmployeeType getEmpType() {
                return empType;
        }

        public void setEmpType(EmployeeType empType) {
                this.empType = empType;
        }

        public String getDateOfBirthString() {
                return dateOfBirthString;
        }

        public void setDateOfBirthString(String dateOfBirthString) {
                this.dateOfBirthString = dateOfBirthString;
        }
}
