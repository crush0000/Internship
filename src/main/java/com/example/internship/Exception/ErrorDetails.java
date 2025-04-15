package com.example.internship.Exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorDetails {

    private String errorCode;
    private String errorMessage;

    public ErrorDetails(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
