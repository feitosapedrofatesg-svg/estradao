package com.agroStartup.estradao.business.chatbot;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemChatbotDTO {

    @NotBlank(message = "Telefone é obrigatório.")
    private String telefone;

    @NotBlank(message = "Mensagem é obrigatória.")
    private String mensagem;
}
