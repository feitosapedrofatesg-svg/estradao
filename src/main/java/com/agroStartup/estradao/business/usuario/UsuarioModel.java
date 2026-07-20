package com.agroStartup.estradao.business.usuario;

import com.agroStartup.estradao.business.localizacao.LocalizacaoModel;
import com.agroStartup.estradao.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UsuarioModel extends BaseModel {

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    private String telefone;

    @Column(unique = true, length = 150)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localizacao_id")
    private LocalizacaoModel localizacao;

    @Column(nullable = false)
    private Boolean whatsapp = true;

    private LocalDateTime ultimoAcesso;
}
