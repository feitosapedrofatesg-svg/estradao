package com.agroStartup.estradao.business.produtor;

import com.agroStartup.estradao.business.localizacao.LocalizacaoModel;
import com.agroStartup.estradao.core.mapper.IGenericMapper;
import org.springframework.stereotype.Component;

@Component
public class ProdutorMapper implements IGenericMapper<ProdutorModel, ProdutorDTO> {

    @Override
    public ProdutorDTO toDTO(ProdutorModel entity) {
        ProdutorDTO dto = new ProdutorDTO();
        dto.setId(entity.getId());
        dto.setAtivo(entity.getAtivo());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        dto.setNome(entity.getNome());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());
        dto.setNomePropriedade(entity.getNomePropriedade());
        dto.setTipoProdutor(entity.getTipoProdutor());

        if (entity.getLocalizacao() != null) {
            dto.setLocalizacaoId(entity.getLocalizacao().getId());
        }

        return dto;
    }

    @Override
    public ProdutorModel toEntity(ProdutorDTO dto) {
        ProdutorModel entity = new ProdutorModel();
        updateEntityFromDTO(dto, entity);
        return entity;
    }

    @Override
    public void updateEntityFromDTO(ProdutorDTO dto, ProdutorModel entity) {
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setNomePropriedade(dto.getNomePropriedade());
        entity.setTipoProdutor(dto.getTipoProdutor());

        if (dto.getLocalizacaoId() != null) {
            LocalizacaoModel localizacao = new LocalizacaoModel();
            localizacao.setId(dto.getLocalizacaoId());
            entity.setLocalizacao(localizacao);
        } else {
            entity.setLocalizacao(null);
        }
    }
}
