package com.example.carparkproject.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    private final ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Chuyển đổi từ Entity sang DTO
    public <E, D> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    // Chuyển đổi từ DTO sang Entity
    public <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
