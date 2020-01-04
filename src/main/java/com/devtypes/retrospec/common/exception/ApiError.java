package com.devtypes.retrospec.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ApiError {
    private String field;
    private String message;

    public ApiError(String message) {
        this.message = message;
    }
}
