package com.devtypes.retrospec.common.rest;

import com.devtypes.retrospec.common.exception.RetrospecError;
import lombok.Getter;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.List;

@ParametersAreNonnullByDefault
@Getter
public class Envelope<T> {

    private Object payload;
    private List<RetrospecError> errors;

    public Envelope(T payload) {
        this.payload = payload;
    }

    public Envelope(List<T> payload) {
        this.payload = payload;
    }

    public Envelope(@Nullable Object payload, @Nullable List<RetrospecError> errors) {
        this.payload = payload;
        this.errors = errors;
    }

    public static Envelope ok() {
        return Envelope.ok(Collections.emptyList());
    }

    // Make access public when needed
    private static Envelope ok(Object payload) {
        return new Envelope<>(payload);
    }

    public static Envelope error(List<RetrospecError> errors) {
        return new Envelope<>(null, errors);
    }

    public static Envelope error(String errorMessage) {
        return Envelope.error(Collections.singletonList(new RetrospecError(errorMessage)));
    }

}
