package com.agroStartup.estradao.business.conversa;

import com.agroStartup.estradao.business.frete.FreteModel;
import com.agroStartup.estradao.business.usuario.UsuarioModel;
import com.agroStartup.estradao.core.model.BaseModel;
import com.agroStartup.estradao.enums.EstadoConversa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "conversas")
public class ConversaModel extends BaseModel {

    @Column(nullable = false, length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private EstadoConversa estadoConversa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frete_em_criacao_id")
    private FreteModel freteEmCriacao;

    @Column(length = 500)
    private String ultimaMensagem;

    private LocalDateTime ultimaInteracao;
}
