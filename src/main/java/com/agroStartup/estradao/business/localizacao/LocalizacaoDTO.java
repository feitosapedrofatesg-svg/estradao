package com.agroStartup.estradao.business.localizacao;

import com.agroStartup.estradao.core.dtos.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LocalizacaoDTO extends BaseDTO {

    @NotBlank(message = "Cidade é obrigatória.")
    private String cidade;

    @NotBlank(message = "UF é obrigatória.")
    @Size(min = 2, max = 2, message = "UF deve ter 2 caracteres.")
    private String uf;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
