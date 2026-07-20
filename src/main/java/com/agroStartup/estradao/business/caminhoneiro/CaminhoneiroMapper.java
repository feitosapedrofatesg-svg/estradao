package com.agroStartup.estradao.business.caminhoneiro;

import com.agroStartup.estradao.business.localizacao.LocalizacaoModel;
import com.agroStartup.estradao.core.mapper.IGenericMapper;
import org.springframework.stereotype.Component;

@Component
public class CaminhoneiroMapper implements IGenericMapper<CaminhoneiroModel, CaminhoneiroDTO> {

    @Override
    public CaminhoneiroDTO toDTO(CaminhoneiroModel entity) {
        CaminhoneiroDTO dto = new CaminhoneiroDTO();
        dto.setId(entity.getId());
        dto.setAtivo(entity.getAtivo());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        dto.setNome(entity.getNome());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());
        dto.setCpf(entity.getCpf());
        dto.setCnh(entity.getCnh());
        dto.setDisponibilidade(entity.getDisponibilidade());
        dto.setRaioAtuacaoKm(entity.getRaioAtuacaoKm());
        dto.setAvaliacaoMedia(entity.getAvaliacaoMedia());

        if (entity.getLocalizacao() != null) {
            dto.setLocalizacaoId(entity.getLocalizacao().getId());
        }

        return dto;
    }

    @Override
    public CaminhoneiroModel toEntity(CaminhoneiroDTO dto) {
        CaminhoneiroModel entity = new CaminhoneiroModel();
        updateEntityFromDTO(dto, entity);
        return entity;
    }

    @Override
    public void updateEntityFromDTO(CaminhoneiroDTO dto, CaminhoneiroModel entity) {
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setCpf(dto.getCpf());
        entity.setCnh(dto.getCnh());
        entity.setDisponibilidade(dto.getDisponibilidade() != null ? dto.getDisponibilidade() : true);
        entity.setRaioAtuacaoKm(dto.getRaioAtuacaoKm());
        entity.setAvaliacaoMedia(dto.getAvaliacaoMedia());

        if (dto.getLocalizacaoId() != null) {
            LocalizacaoModel localizacao = new LocalizacaoModel();
            localizacao.setId(dto.getLocalizacaoId());
            entity.setLocalizacao(localizacao);
        } else {
            entity.setLocalizacao(null);
        }
    }
}
