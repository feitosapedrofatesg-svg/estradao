package com.agroStartup.estradao.business.assinatura;

import com.agroStartup.estradao.business.caminhoneiro.CaminhoneiroModel;
import com.agroStartup.estradao.core.model.BaseModel;
import com.agroStartup.estradao.enums.PlanoAssinatura;
import com.agroStartup.estradao.enums.StatusAssinatura;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assinaturas")
public class AssinaturaModel extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PlanoAssinatura plano;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusAssinatura status;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caminhoneiro_id", nullable = false, unique = true)
    private CaminhoneiroModel caminhoneiro;
}
