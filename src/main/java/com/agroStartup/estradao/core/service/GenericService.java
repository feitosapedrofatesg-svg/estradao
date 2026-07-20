package com.agroStartup.estradao.core.service;

import com.agroStartup.estradao.core.exception.ResourceNotFoundException;
import com.agroStartup.estradao.core.mapper.IGenericMapper;
import com.agroStartup.estradao.core.model.BaseModel;
import com.agroStartup.estradao.core.repository.IGenericRepository;
import com.agroStartup.estradao.core.validation.GenericValidation;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class GenericService<E extends BaseModel, D> {

    protected final IGenericRepository<E> repository;
    protected final IGenericMapper<E, D> mapper;
    protected final GenericValidation<E> validation;

    protected GenericService(
            IGenericRepository<E> repository,
            IGenericMapper<E, D> mapper,
            GenericValidation<E> validation
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.validation = validation;
    }

    public List<D> findAll() {
        return repository.findAllByAtivoTrue()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public D findById(Long id) {
        E entity = findEntityById(id);
        return mapper.toDTO(entity);
    }

    @Transactional
    public D insert(D dto) {
        E entity = mapper.toEntity(dto);
        validation.validateInsert(entity);
        E saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Transactional
    public D update(Long id, D dto) {
        E entity = findEntityById(id);
        mapper.updateEntityFromDTO(dto, entity);
        validation.validateUpdate(entity);
        E saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        E entity = findEntityById(id);
        validation.validateDelete(entity);
        entity.setAtivo(false);
        repository.save(entity);
    }

    protected E findEntityById(Long id) {
        return repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado. ID: " + id));
    }
}
