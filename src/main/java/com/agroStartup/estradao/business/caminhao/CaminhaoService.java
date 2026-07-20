package com.agroStartup.estradao.business.caminhao;

import com.agroStartup.estradao.core.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService extends GenericService<CaminhaoModel, CaminhaoDTO> {

    public CaminhaoService(
            CaminhaoRepository repository,
            CaminhaoMapper mapper,
            CaminhaoValidation validation
    ) {
        super(repository, mapper, validation);
    }
}
