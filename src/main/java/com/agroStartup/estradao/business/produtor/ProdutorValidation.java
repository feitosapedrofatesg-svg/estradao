package com.agroStartup.estradao.business.produtor;

import com.agroStartup.estradao.core.exception.BusinessException;
import com.agroStartup.estradao.core.validation.GenericValidation;
import org.springframework.stereotype.Component;

@Component
public class ProdutorValidation extends GenericValidation<ProdutorModel> {

    private final ProdutorRepository repository;

    public ProdutorValidation(ProdutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateInsert(ProdutorModel entity) {
        validarTelefoneUnico(entity);
        validarEmailUnico(entity);
    }

    @Override
    public void validateUpdate(ProdutorModel entity) {
        validarTelefoneUnico(entity);
        validarEmailUnico(entity);
    }

    private void validarTelefoneUnico(ProdutorModel entity) {
        repository.findByTelefoneAndAtivoTrue(entity.getTelefone())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um produtor cadastrado com este telefone.");
                });
    }

    private void validarEmailUnico(ProdutorModel entity) {
        if (entity.getEmail() == null || entity.getEmail().isBlank()) {
            return;
        }

        repository.findByEmailAndAtivoTrue(entity.getEmail())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um produtor cadastrado com este e-mail.");
                });
    }
}
