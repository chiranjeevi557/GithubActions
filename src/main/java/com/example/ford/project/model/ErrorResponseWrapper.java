package com.example.ford.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseWrapper {
    private String requestStatus;
    private String lastRequested;
    private ErrorResponse errorResponse;
}
