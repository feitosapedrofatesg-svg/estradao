package com.agroStartup.estradao.business.caminhao;

import com.agroStartup.estradao.core.dtos.BaseDTO;
import com.agroStartup.estradao.enums.TipoCaminhao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CaminhaoDTO extends BaseDTO {

    @NotBlank(message = "Placa é obrigatória.")
    private String placa;

    @NotBlank(message = "Marca é obrigatória.")
    private String marca;

    @NotBlank(message = "Modelo é obrigatório.")
    private String modelo;

    private Integer ano;

    @NotNull(message = "Capacidade em toneladas é obrigatória.")
    private BigDecimal capacidadeToneladas;

    @NotNull(message = "Tipo do caminhão é obrigatório.")
    private TipoCaminhao tipoCaminhao;

    @NotNull(message = "Caminhoneiro é obrigatório.")
    private Long caminhoneiroId;
}
