package com.agroStartup.estradao.core.mapper;

public interface IGenericMapper<E, D> {

    D toDTO(E entity);

    E toEntity(D dto);

    void updateEntityFromDTO(D dto, E entity);
}
