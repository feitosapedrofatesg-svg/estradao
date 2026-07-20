package com.agroStartup.estradao.business.produtor;

import com.agroStartup.estradao.core.dtos.BaseDTO;
import com.agroStartup.estradao.enums.TipoProdutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutorDTO extends BaseDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório.")
    private String telefone;

    private String email;

    private Long localizacaoId;

    private String nomePropriedade;

    @NotNull(message = "Tipo do produtor é obrigatório.")
    private TipoProdutor tipoProdutor;
}
