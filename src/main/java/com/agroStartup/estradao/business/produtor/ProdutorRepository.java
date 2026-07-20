package com.agroStartup.estradao.business.produtor;

import com.agroStartup.estradao.core.repository.IGenericRepository;

import java.util.Optional;

public interface ProdutorRepository extends IGenericRepository<ProdutorModel> {

    Optional<ProdutorModel> findByTelefoneAndAtivoTrue(String telefone);

    Optional<ProdutorModel> findByEmailAndAtivoTrue(String email);
}
