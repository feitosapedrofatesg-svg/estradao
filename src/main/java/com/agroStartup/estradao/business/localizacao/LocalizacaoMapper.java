package com.agroStartup.estradao.business.localizacao;

import com.agroStartup.estradao.core.mapper.IGenericMapper;
import org.springframework.stereotype.Component;

@Component
public class LocalizacaoMapper implements IGenericMapper<LocalizacaoModel, LocalizacaoDTO> {

    @Override
    public LocalizacaoDTO toDTO(LocalizacaoModel entity) {
        LocalizacaoDTO dto = new LocalizacaoDTO();
        dto.setId(entity.getId());
        dto.setAtivo(entity.getAtivo());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        dto.setCidade(entity.getCidade());
        dto.setUf(entity.getUf());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        return dto;
    }

    @Override
    public LocalizacaoModel toEntity(LocalizacaoDTO dto) {
        LocalizacaoModel entity = new LocalizacaoModel();
        updateEntityFromDTO(dto, entity);
        return entity;
    }

    @Override
    public void updateEntityFromDTO(LocalizacaoDTO dto, LocalizacaoModel entity) {
        entity.setCidade(dto.getCidade());
        entity.setUf(dto.getUf() != null ? dto.getUf().toUpperCase() : null);
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
    }
}
