package com.springboot.DTO;
import com.springboot.Entity.CourseAssignment;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CourseDTO {

    private int cId;
    private String cName;
    private String cDescription;
    private String cDuration;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<CourseAssignment> courseAssignment;

}
