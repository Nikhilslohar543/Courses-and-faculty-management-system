package com.springboot.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceDTO {

    private int aId;
    private String aStatus;
    private LocalDate aDate;
    private String aDescription;
    private int facultyId;
}
