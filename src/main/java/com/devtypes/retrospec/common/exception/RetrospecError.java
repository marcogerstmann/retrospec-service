package com.devtypes.retrospec.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class RetrospecError {
    private String field;
    private String message;

    public RetrospecError(String message) {
        this.message = message;
    }
}
