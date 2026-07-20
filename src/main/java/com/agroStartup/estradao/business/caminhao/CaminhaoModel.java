package com.agroStartup.estradao.business.caminhao;

import com.agroStartup.estradao.business.caminhoneiro.CaminhoneiroModel;
import com.agroStartup.estradao.core.model.BaseModel;
import com.agroStartup.estradao.enums.TipoCaminhao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "caminhoes")
public class CaminhaoModel extends BaseModel {

    @Column(nullable = false, unique = true, length = 10)
    private String placa;

    @Column(nullable = false, length = 80)
    private String marca;

    @Column(nullable = false, length = 80)
    private String modelo;

    private Integer ano;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal capacidadeToneladas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoCaminhao tipoCaminhao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caminhoneiro_id", nullable = false)
    private CaminhoneiroModel caminhoneiro;
}
