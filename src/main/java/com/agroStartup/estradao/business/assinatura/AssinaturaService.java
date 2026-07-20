package com.agroStartup.estradao.business.assinatura;

import com.agroStartup.estradao.core.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService extends GenericService<AssinaturaModel, AssinaturaDTO> {

    public AssinaturaService(
            AssinaturaRepository repository,
            AssinaturaMapper mapper,
            AssinaturaValidation validation
    ) {
        super(repository, mapper, validation);
    }
}
