package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.mapper.EntityDtoConverter;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public abstract class AbstractCrudService<E, D, ID> {
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @Autowired
    private JpaRepository<E, ID> repository;

    @PostConstruct
    public void initDB() {
        List<E> entities = IntStream.rangeClosed(1, 200)
                .mapToObj(this::createEntity)
                .collect(Collectors.toList());
        repository.saveAll(entities);
    }

    protected abstract E createEntity(int i);

    public List<D> viewAll(Class<D> dtoClass) {
        return repository.findAll()
                .stream()
                .map(entity -> entityDtoConverter.convertToDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    public void add(D dto, Class<E> entityClass) {
        E entity = entityDtoConverter.convertToEntity(dto, entityClass);
        repository.save(entity);
    }
}
