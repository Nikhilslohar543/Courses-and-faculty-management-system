package com.springboot.DTO;

import com.springboot.Entity.Attendance;
import com.springboot.Entity.CourseAssignment;
import lombok.Data;

import java.util.List;

@Data
public class FacultyDTO {

    private int fId;
    private String fName;
    private String fEmail;
    private String fRole;
    private String fGender;
    private long mobno;
    private String fUsername;
    private String status;
    private List<CourseAssignment> courseAssignment;
    private List<Attendance> attendance;

}
