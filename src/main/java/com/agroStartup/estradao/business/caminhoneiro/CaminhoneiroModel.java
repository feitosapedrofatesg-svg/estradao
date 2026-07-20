package com.agroStartup.estradao.business.caminhoneiro;

import com.agroStartup.estradao.business.usuario.UsuarioModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "caminhoneiros")
public class CaminhoneiroModel extends UsuarioModel {

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, unique = true, length = 20)
    private String cnh;

    @Column(nullable = false)
    private Boolean disponibilidade = true;

    @Column(nullable = false)
    private Integer raioAtuacaoKm;

    @Column(precision = 3, scale = 2)
    private BigDecimal avaliacaoMedia;
}
