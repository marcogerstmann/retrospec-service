package com.devtypes.retrospec.common.exception;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RetrospecNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4699636364667560957L;

    private RetrospecEntity notFoundEntity;
    private UUID notFoundId;

    public RetrospecNotFoundException(RetrospecEntity notFoundEntity, UUID notFoundId) {
        super(String.format("Entity %s with id %s not found", notFoundEntity, notFoundId));
        this.notFoundEntity = notFoundEntity;
        this.notFoundId = notFoundId;
    }
}
