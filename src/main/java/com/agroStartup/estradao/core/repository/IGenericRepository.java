package com.agroStartup.estradao.core.repository;

import com.agroStartup.estradao.core.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface IGenericRepository<T extends BaseModel> extends JpaRepository<T, Long> {

    Optional<T> findByIdAndAtivoTrue(Long id);

    List<T> findAllByAtivoTrue();
}
