package com.agroStartup.estradao.business.localizacao;

import com.agroStartup.estradao.core.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "localizacoes")
public class LocalizacaoModel extends BaseModel {

    @Column(nullable = false, length = 120)
    private String cidade;


    @Column(nullable = false, length = 2)
    private String uf;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;
}
