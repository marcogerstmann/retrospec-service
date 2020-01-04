package com.devtypes.retrospec.common.exception;

import com.devtypes.retrospec.common.enums.Entity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RetrospecNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4699636364667560957L;

    private Entity notFoundEntity;
    private UUID notFoundId;

    public RetrospecNotFoundException(Entity notFoundEntity, UUID notFoundId) {
        super(String.format("Entity %s with id %s not found", notFoundEntity, notFoundId));
        this.notFoundEntity = notFoundEntity;
        this.notFoundId = notFoundId;
    }
}
