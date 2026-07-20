package com.agroStartup.estradao.business.assinatura;

import com.agroStartup.estradao.core.dtos.BaseDTO;
import com.agroStartup.estradao.enums.PlanoAssinatura;
import com.agroStartup.estradao.enums.StatusAssinatura;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AssinaturaDTO extends BaseDTO {

    @NotNull(message = "Plano é obrigatório.")
    private PlanoAssinatura plano;

    @NotNull(message = "Status da assinatura é obrigatório.")
    private StatusAssinatura status;

    @NotNull(message = "Data de início é obrigatória.")
    private LocalDate dataInicio;

    @NotNull(message = "Data de fim é obrigatória.")
    private LocalDate dataFim;

    @NotNull(message = "Caminhoneiro é obrigatório.")
    private Long caminhoneiroId;
}
