package com.code.salesappbackend.services.impls;

import com.code.salesappbackend.services.interfaces.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    private final JpaRepository<T, ID> repository;

    public BaseServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T update(ID id, T t) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("Not found data"));
        return repository.save(t);
    }

    @Override
    public T updatePatch(ID id, Map<String, ?> data) {
        return null;
    }
}
