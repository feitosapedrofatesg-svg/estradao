package com.agroStartup.estradao.business.assinatura;

import com.agroStartup.estradao.core.exception.BusinessException;
import com.agroStartup.estradao.core.validation.GenericValidation;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaValidation extends GenericValidation<AssinaturaModel> {

    private final AssinaturaRepository repository;

    public AssinaturaValidation(AssinaturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateInsert(AssinaturaModel entity) {
        validarDatas(entity);
        validarAssinaturaUnicaPorCaminhoneiro(entity);
    }

    @Override
    public void validateUpdate(AssinaturaModel entity) {
        validarDatas(entity);
        validarAssinaturaUnicaPorCaminhoneiro(entity);
    }

    private void validarDatas(AssinaturaModel entity) {
        if (entity.getDataInicio() != null && entity.getDataFim() != null
                && entity.getDataFim().isBefore(entity.getDataInicio())) {
            throw new BusinessException("A data final da assinatura não pode ser anterior à data inicial.");
        }
    }

    private void validarAssinaturaUnicaPorCaminhoneiro(AssinaturaModel entity) {
        if (entity.getCaminhoneiro() == null || entity.getCaminhoneiro().getId() == null) {
            return;
        }

        repository.findByCaminhoneiro_IdAndAtivoTrue(entity.getCaminhoneiro().getId())
                .filter(existing -> !existing.getId().equals(entity.getId()))
                .ifPresent(existing -> {
                    throw new BusinessException("Este caminhoneiro já possui uma assinatura cadastrada.");
                });
    }
}
