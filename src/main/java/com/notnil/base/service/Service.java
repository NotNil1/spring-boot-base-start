package com.notnil.base.service;

import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @author NotNil
 */
public interface Service<T, ID extends Serializable> {
    void save(T model);

    void deleteById(ID id);

    void update(T model, ID id);

    T findById(ID id);

    List<T> findAll();

    List<T> findAll(Pageable pageable);
}
