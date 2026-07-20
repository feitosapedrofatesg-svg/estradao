package com.agroStartup.estradao.business.localizacao;

import com.agroStartup.estradao.core.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService extends GenericService<LocalizacaoModel, LocalizacaoDTO> {

    public LocalizacaoService(
            LocalizacaoRepository repository,
            LocalizacaoMapper mapper,
            LocalizacaoValidation validation
    ) {
        super(repository, mapper, validation);
    }
}
