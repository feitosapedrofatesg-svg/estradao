package com.agroStartup.estradao.business.caminhao;

import com.agroStartup.estradao.core.repository.IGenericRepository;

import java.util.Optional;

public interface CaminhaoRepository extends IGenericRepository<CaminhaoModel> {

    Optional<CaminhaoModel> findByPlacaAndAtivoTrue(String placa);
}
