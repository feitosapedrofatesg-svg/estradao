package com.agroStartup.estradao.business.caminhao;

import com.agroStartup.estradao.business.caminhoneiro.CaminhoneiroModel;
import com.agroStartup.estradao.core.mapper.IGenericMapper;
import org.springframework.stereotype.Component;

@Component
public class CaminhaoMapper implements IGenericMapper<CaminhaoModel, CaminhaoDTO> {

    @Override
    public CaminhaoDTO toDTO(CaminhaoModel entity) {
        CaminhaoDTO dto = new CaminhaoDTO();
        dto.setId(entity.getId());
        dto.setAtivo(entity.getAtivo());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        dto.setPlaca(entity.getPlaca());
        dto.setMarca(entity.getMarca());
        dto.setModelo(entity.getModelo());
        dto.setAno(entity.getAno());
        dto.setCapacidadeToneladas(entity.getCapacidadeToneladas());
        dto.setTipoCaminhao(entity.getTipoCaminhao());

        if (entity.getCaminhoneiro() != null) {
            dto.setCaminhoneiroId(entity.getCaminhoneiro().getId());
        }

        return dto;
    }

    @Override
    public CaminhaoModel toEntity(CaminhaoDTO dto) {
        CaminhaoModel entity = new CaminhaoModel();
        updateEntityFromDTO(dto, entity);
        return entity;
    }

    @Override
    public void updateEntityFromDTO(CaminhaoDTO dto, CaminhaoModel entity) {
        entity.setPlaca(dto.getPlaca());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setAno(dto.getAno());
        entity.setCapacidadeToneladas(dto.getCapacidadeToneladas());
        entity.setTipoCaminhao(dto.getTipoCaminhao());

        if (dto.getCaminhoneiroId() != null) {
            CaminhoneiroModel caminhoneiro = new CaminhoneiroModel();
            caminhoneiro.setId(dto.getCaminhoneiroId());
            entity.setCaminhoneiro(caminhoneiro);
        }
    }
}
