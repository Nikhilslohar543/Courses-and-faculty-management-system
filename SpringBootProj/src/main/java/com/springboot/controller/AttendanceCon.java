package com.springboot.controller;

import com.springboot.DTO.AttendanceDTO;
import com.springboot.Responses.APIResponse;
import com.springboot.services.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class AttendanceCon {

    @Autowired
    private AttendanceService aSer;

    @GetMapping("/attendance/{fId}")
    public ResponseEntity<?> getAttendance(@PathVariable int fId) {

        List<AttendanceDTO> data = aSer.getAttendance(fId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Attendance fetched successfully")
                        .data(data)
                        .build()
        );
    }

    @GetMapping("/attendance/{fId}/{aId}")
    public ResponseEntity<?> getAttendanceById(@PathVariable int fId, @PathVariable int aId) {

        AttendanceDTO data = aSer.getAttendanceById(fId, aId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Attendance fetched successfully")
                        .data(data)
                        .build()
        );
    }

    @PostMapping("/attendance/{fId}")
    public ResponseEntity<?> addAttendance(@PathVariable int fId, @RequestBody AttendanceDTO dto) {

        AttendanceDTO data = aSer.addAttendance(fId, dto);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Attendance added successfully")
                        .data(data)
                        .build()
        );
    }

    @PutMapping("/attendance/{fId}")
    public ResponseEntity<?> updateAttendance(@PathVariable int fId, @RequestBody AttendanceDTO dto) {

        AttendanceDTO data = aSer.updateAttendance(fId, dto);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg("Attendance updated successfully")
                        .data(data)
                        .build()
        );
    }

    @DeleteMapping("/attendance/{fId}/{aId}")
    public ResponseEntity<?> deleteAttendance(@PathVariable int fId, @PathVariable int aId) {

        String msg = aSer.deleteAttendance(fId, aId);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .success(true)
                        .msg(msg)
                        .build()
        );
    }
}