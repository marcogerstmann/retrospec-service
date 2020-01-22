package com.devtypes.retrospec.common.base;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ParametersAreNonnullByDefault
@Transactional
public abstract class BaseDataServiceImpl<T, V extends BaseVo> implements BaseDataService<V> {

    private final JpaRepository<T, UUID> repository;
    private final AbstractConverter<T, V> converter;

    public BaseDataServiceImpl(JpaRepository<T, UUID> repository, AbstractConverter<T, V> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    private V save(T e) {
        return converter.convertEntityToVo(repository.save(e));
    }

    @Nonnull
    @Override
    public List<V> findAll() {
        return converter.convertEntityToVo(repository.findAll());
    }

    @Nonnull
    @Override
    public Optional<V> findById(UUID id) {
        return repository.findById(id).map(converter::convertEntityToVo);
    }

    @Nonnull
    @Override
    public V create(V vo) {
        return save(converter.convertVoToEntity(vo));
    }

    @Nonnull
    @Override
    public V updateById(UUID id, V vo) {
        return repository.findById(id)
                .map(entity -> save(converter.updateEntityFromVo(entity, vo)))
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.UNSPECIFIED, id));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public V createOrUpdate(RetrospecEntity entity, V vo, @Nullable UUID id) {
        if (id != null) {
            repository.findById(id)
                    .filter(v -> id.equals(vo.getId()))
                    .orElseThrow(() -> new RetrospecNotFoundException(entity, vo.getId()));
        }

        return create(vo);
    }

}
