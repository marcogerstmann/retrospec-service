package com.devtypes.retrospec.common.base;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import com.devtypes.retrospec.common.rest.Envelope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@ParametersAreNonnullByDefault
public abstract class BaseController<V extends BaseVo, S extends IDataService<V>> {

    private final S service;

    public BaseController(S service) {
        this.service = service;
    }

    @Nonnull
    @GetMapping("")
    protected Envelope<V> index() {
        return new Envelope<>(service.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    protected Envelope get(@PathVariable UUID id) {
        return service.findById(id)
                .map(Envelope::new)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.UNSPECIFIED, id));
    }

    @Nonnull
    @PostMapping("")
    protected Envelope<V> post(@RequestBody @Valid V vo) {
        return new Envelope<>(service.create(vo));
    }

    @Nonnull
    @PutMapping("{id}")
    protected Envelope<V> put(@PathVariable UUID id, @RequestBody @Valid V vo) {
        return new Envelope<>(service.updateById(id, vo));
    }

    @Nonnull
    @DeleteMapping("{id}")
    protected Envelope delete(@PathVariable UUID id) {
        service.deleteById(id);
        return Envelope.ok();
    }

}

