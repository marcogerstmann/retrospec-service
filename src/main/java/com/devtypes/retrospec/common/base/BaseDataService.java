package com.devtypes.retrospec.common.base;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface BaseDataService<V extends BaseVo> {

    @Nonnull
    List<V> findAll();

    @Nonnull
    Optional<V> findById(UUID id);

    @Nonnull
    V create(V vo);

    @Nonnull
    V updateById(UUID id, V vo);

    void deleteById(UUID id);

    V createOrUpdate(RetrospecEntity entity, V vo, @Nullable UUID id);
}
