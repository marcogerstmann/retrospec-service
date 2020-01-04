package com.devtypes.retrospec.common.base;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ParametersAreNonnullByDefault
@Component
public abstract class AbstractConverter<T, V> implements IConverter<T, V> {

    private Mapper mapper;
    private Class<T> tClazz;
    private Class<V> vClazz;

    public AbstractConverter(Mapper mapper, Class<T> tClazz, Class<V> vClazz) {
        this.mapper = mapper;
        this.tClazz = tClazz;
        this.vClazz = vClazz;
    }

    @Override
    @Nonnull
    public V convertEntityToVo(T t) {
        return mapEntityToVo(mapper.map(t, vClazz), t);
    }

    @Override
    @Nonnull
    public List<V> convertEntityToVo(Collection<T> tList) {
        return tList.stream().map(this::convertEntityToVo).collect(Collectors.toList());
    }

    @Override
    @Nonnull
    public T convertVoToEntity(V v) {
        return mapVoToEntity(mapper.map(v, tClazz), v);
    }

    @Override
    @Nonnull
    public List<T> convertVoToEntity(Collection<V> vList) {
        return vList.stream().map(this::convertVoToEntity).collect(Collectors.toList());
    }

    @Override
    @Nonnull
    public T updateEntityFromVo(T t, V v) {
        mapper.map(v, mapVoToEntity(t, v));
        return t;
    }

    private V mapEntityToVo(V v, T t) {
        return v;
    }

    private T mapVoToEntity(T t, V v) {
        return t;
    }
}
