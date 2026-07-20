package com.agroStartup.estradao.business.caminhoneiro;

import com.agroStartup.estradao.core.exception.BusinessException;
import com.agroStartup.estradao.core.validation.GenericValidation;
import org.springframework.stereotype.Component;

@Component
public class CaminhoneiroValidation extends GenericValidation<CaminhoneiroModel> {

    private final CaminhoneiroRepository repository;

    public CaminhoneiroValidation(CaminhoneiroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateInsert(CaminhoneiroModel entity) {
        validarTelefoneUnico(entity);
        validarEmailUnico(entity);
        validarCpfUnico(entity);
        validarCnhUnica(entity);
    }

    @Override
    public void validateUpdate(CaminhoneiroModel entity) {
        validarTelefoneUnico(entity);
        validarEmailUnico(entity);
        validarCpfUnico(entity);
        validarCnhUnica(entity);
    }

    private void validarTelefoneUnico(CaminhoneiroModel entity) {
        repository.findByTelefoneAndAtivoTrue(entity.getTelefone())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um caminhoneiro cadastrado com este telefone.");
                });
    }

    private void validarEmailUnico(CaminhoneiroModel entity) {
        if (entity.getEmail() == null || entity.getEmail().isBlank()) {
            return;
        }

        repository.findByEmailAndAtivoTrue(entity.getEmail())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um caminhoneiro cadastrado com este e-mail.");
                });
    }

    private void validarCpfUnico(CaminhoneiroModel entity) {
        repository.findByCpfAndAtivoTrue(entity.getCpf())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um caminhoneiro cadastrado com este CPF.");
                });
    }

    private void validarCnhUnica(CaminhoneiroModel entity) {
        repository.findByCnhAndAtivoTrue(entity.getCnh())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Já existe um caminhoneiro cadastrado com esta CNH.");
                });
    }
}
