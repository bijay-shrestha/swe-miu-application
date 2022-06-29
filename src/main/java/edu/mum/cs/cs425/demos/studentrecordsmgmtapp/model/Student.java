package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author bijayshrestha on 6/29/22
 * @project swe-miu-application
 */
public class Student{

    static final String americanDatePattern = "MM/dd/yyyy";
    static final DateTimeFormatter americanDateFormatter = DateTimeFormatter.ofPattern(americanDatePattern);

    private Integer studentId;
    private String name;
    private LocalDate dateOfAdmission;

    public Student() {
    }

    public Student(Integer studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Student(String name, LocalDate dateOfAdmission) {
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", dateOfAdmission=" +  americanDateFormatter.format(dateOfAdmission) +
                '}';
    }

}
