package com.agroStartup.estradao.business.chatbot;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    private final ChatbotService service;

    public ChatbotController(ChatbotService service) {
        this.service = service;
    }

    @PostMapping("/mensagem")
    public WhatsAppResponseDTO receberMensagem(@RequestBody @Valid MensagemChatbotDTO dto) {
        return service.processarMensagem(dto);
    }
}
