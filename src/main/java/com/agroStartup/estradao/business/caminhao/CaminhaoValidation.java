package com.agroStartup.estradao.business.caminhao;

import com.agroStartup.estradao.core.exception.BusinessException;
import com.agroStartup.estradao.core.validation.GenericValidation;
import org.springframework.stereotype.Component;

@Component
public class CaminhaoValidation extends GenericValidation<CaminhaoModel> {

    private final CaminhaoRepository repository;

    public CaminhaoValidation(CaminhaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateInsert(CaminhaoModel entity) {
        validarPlacaUnica(entity);
    }

    @Override
    public void validateUpdate(CaminhaoModel entity) {
        validarPlacaUnica(entity);
    }

    private void validarPlacaUnica(CaminhaoModel entity) {
        repository.findByPlacaAndAtivoTrue(entity.getPlaca())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um caminhão cadastrado com esta placa.");
                });
    }
}
