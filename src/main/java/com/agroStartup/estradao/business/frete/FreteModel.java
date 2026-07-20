package com.agroStartup.estradao.business.frete;

import com.agroStartup.estradao.business.localizacao.LocalizacaoModel;
import com.agroStartup.estradao.business.produtor.ProdutorModel;
import com.agroStartup.estradao.core.model.BaseModel;
import com.agroStartup.estradao.enums.StatusFrete;
import com.agroStartup.estradao.enums.TipoCarga;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fretes")
public class FreteModel extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtor_id", nullable = false)
    private ProdutorModel produtor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origem_id", nullable = false)
    private LocalizacaoModel origem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destino_id", nullable = false)
    private LocalizacaoModel destino;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoCarga tipoCarga;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pesoToneladas;

    private LocalDate dataColeta;

    @Column(length = 500)
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusFrete statusFrete = StatusFrete.ABERTO;
}
