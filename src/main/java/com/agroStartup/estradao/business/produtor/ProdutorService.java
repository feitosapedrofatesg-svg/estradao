package com.agroStartup.estradao.business.produtor;

import com.agroStartup.estradao.core.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService extends GenericService<ProdutorModel, ProdutorDTO> {

    public ProdutorService(
            ProdutorRepository repository,
            ProdutorMapper mapper,
            ProdutorValidation validation
    ) {
        super(repository, mapper, validation);
    }
}
