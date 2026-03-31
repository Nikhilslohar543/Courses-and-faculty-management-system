package com.springboot.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class APIResponse<T> {

    private boolean success;
    private String msg;
    private T data;
    private LocalDateTime timeStamp;


    public APIResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }

}
