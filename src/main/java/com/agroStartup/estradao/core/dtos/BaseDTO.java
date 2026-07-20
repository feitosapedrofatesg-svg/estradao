package com.agroStartup.estradao.core.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseDTO {

    private Long id;

    private Boolean ativo;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
