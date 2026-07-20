package com.agroStartup.estradao.business.chatbot;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public WhatsAppResponseDTO processarMensagem(MensagemChatbotDTO dto) {
        String resposta = "Olá! Sou o assistente do Estradão. Recebi sua mensagem: " + dto.getMensagem();
        return new WhatsAppResponseDTO(dto.getTelefone(), resposta);
    }
}
