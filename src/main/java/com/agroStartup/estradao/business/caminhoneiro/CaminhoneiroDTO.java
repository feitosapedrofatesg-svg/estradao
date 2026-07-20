package com.agroStartup.estradao.business.caminhoneiro;

import com.agroStartup.estradao.core.dtos.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CaminhoneiroDTO extends BaseDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório.")
    private String telefone;

    private String email;

    private Long localizacaoId;

    @NotBlank(message = "CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "CNH é obrigatória.")
    private String cnh;

    private Boolean disponibilidade;

    @NotNull(message = "Raio de atuação é obrigatório.")
    private Integer raioAtuacaoKm;

    private BigDecimal avaliacaoMedia;
}
