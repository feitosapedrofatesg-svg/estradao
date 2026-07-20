package com.agroStartup.estradao.business.assinatura;

import com.agroStartup.estradao.business.caminhoneiro.CaminhoneiroModel;
import com.agroStartup.estradao.core.mapper.IGenericMapper;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaMapper implements IGenericMapper<AssinaturaModel, AssinaturaDTO> {

    @Override
    public AssinaturaDTO toDTO(AssinaturaModel entity) {
        AssinaturaDTO dto = new AssinaturaDTO();
        dto.setId(entity.getId());
        dto.setAtivo(entity.getAtivo());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        dto.setPlano(entity.getPlano());
        dto.setStatus(entity.getStatus());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFim(entity.getDataFim());

        if (entity.getCaminhoneiro() != null) {
            dto.setCaminhoneiroId(entity.getCaminhoneiro().getId());
        }

        return dto;
    }

    @Override
    public AssinaturaModel toEntity(AssinaturaDTO dto) {
        AssinaturaModel entity = new AssinaturaModel();
        updateEntityFromDTO(dto, entity);
        return entity;
    }

    @Override
    public void updateEntityFromDTO(AssinaturaDTO dto, AssinaturaModel entity) {
        entity.setPlano(dto.getPlano());
        entity.setStatus(dto.getStatus());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());

        if (dto.getCaminhoneiroId() != null) {
            CaminhoneiroModel caminhoneiro = new CaminhoneiroModel();
            caminhoneiro.setId(dto.getCaminhoneiroId());
            entity.setCaminhoneiro(caminhoneiro);
        }
    }
}
