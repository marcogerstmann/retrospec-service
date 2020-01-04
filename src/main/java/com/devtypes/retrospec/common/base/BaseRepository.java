package com.devtypes.retrospec.common.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<V, ID> extends JpaRepository<V, ID> {

}

