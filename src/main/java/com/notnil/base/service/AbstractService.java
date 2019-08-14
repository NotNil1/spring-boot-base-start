package com.notnil.base.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author NotNil
 */
public class AbstractService<T, ID extends Serializable> implements Service<T, ID> {

    @Autowired
    JpaRepository<T, ID> jpaRepository;

    @Override
    public void save(T model) {
        jpaRepository.save(model);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.delete(id);
    }

    @Override
    public T findById(ID id) {
        return jpaRepository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public List<T> findAll(Pageable pageable) {
        Page<T> recordDOPage = jpaRepository.findAll(pageable);
        return recordDOPage.getContent();
    }

    @Override
    public void update(T model, ID id) {
        T t = jpaRepository.findOne(id);
        BeanUtils.copyProperties(model, t, "id");
        jpaRepository.save(t);
    }
}
