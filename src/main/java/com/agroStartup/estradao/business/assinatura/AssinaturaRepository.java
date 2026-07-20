package com.agroStartup.estradao.business.assinatura;

import com.agroStartup.estradao.core.repository.IGenericRepository;

import java.util.Optional;

public interface AssinaturaRepository extends IGenericRepository<AssinaturaModel> {

    Optional<AssinaturaModel> findByCaminhoneiro_IdAndAtivoTrue(Long caminhoneiroId);
}
