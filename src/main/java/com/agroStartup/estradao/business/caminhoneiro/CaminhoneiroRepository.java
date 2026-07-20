package com.agroStartup.estradao.business.caminhoneiro;

import com.agroStartup.estradao.core.repository.IGenericRepository;

import java.util.Optional;

public interface CaminhoneiroRepository extends IGenericRepository<CaminhoneiroModel> {

    Optional<CaminhoneiroModel> findByTelefoneAndAtivoTrue(String telefone);

    Optional<CaminhoneiroModel> findByEmailAndAtivoTrue(String email);

    Optional<CaminhoneiroModel> findByCpfAndAtivoTrue(String cpf);

    Optional<CaminhoneiroModel> findByCnhAndAtivoTrue(String cnh);
}
