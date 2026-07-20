package com.agroStartup.estradao.business.produtor;

import com.agroStartup.estradao.business.usuario.UsuarioModel;
import com.agroStartup.estradao.enums.TipoProdutor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produtores")
public class ProdutorModel extends UsuarioModel {

    @Column(length = 150)
    private String nomePropriedade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoProdutor tipoProdutor;
}
