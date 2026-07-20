package com.agroStartup.estradao.business.proposta;

import com.agroStartup.estradao.business.caminhoneiro.CaminhoneiroModel;
import com.agroStartup.estradao.business.frete.FreteModel;
import com.agroStartup.estradao.core.model.BaseModel;
import com.agroStartup.estradao.enums.StatusProposta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "propostas")
public class PropostaModel extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frete_id", nullable = false)
    private FreteModel frete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caminhoneiro_id", nullable = false)
    private CaminhoneiroModel caminhoneiro;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(length = 500)
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusProposta statusProposta = StatusProposta.ENVIADA;

    private LocalDateTime dataProposta;
}
