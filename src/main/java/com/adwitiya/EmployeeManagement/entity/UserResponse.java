package com.adwitiya.EmployeeManagement.entity;

import lombok.Data;

@Data
public class UserResponse {

    private String errorCode;
    private String errorMessage;

    public UserResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
