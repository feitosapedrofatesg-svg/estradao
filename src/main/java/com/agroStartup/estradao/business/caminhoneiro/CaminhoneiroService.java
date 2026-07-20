package com.agroStartup.estradao.business.caminhoneiro;

import com.agroStartup.estradao.core.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CaminhoneiroService extends GenericService<CaminhoneiroModel, CaminhoneiroDTO> {

    public CaminhoneiroService(
            CaminhoneiroRepository repository,
            CaminhoneiroMapper mapper,
            CaminhoneiroValidation validation
    ) {
        super(repository, mapper, validation);
    }
}
