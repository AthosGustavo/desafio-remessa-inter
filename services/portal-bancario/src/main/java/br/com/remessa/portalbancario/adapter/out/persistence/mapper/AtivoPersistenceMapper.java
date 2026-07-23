package br.com.remessa.portalbancario.adapter.out.persistence.mapper;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.AtivoEntity;
import br.com.remessa.portalbancario.domain.model.Ativo;
import org.springframework.stereotype.Component;

@Component
public class AtivoPersistenceMapper {

    public AtivoEntity toEntity(Ativo ativo) {
        if (ativo == null) {
            return null;
        }

        AtivoEntity entity = new AtivoEntity();
        entity.setId(ativo.getId());
        entity.setMoeda(ativo.getMoeda());
        entity.setValor(ativo.getValor());
        return entity;
    }

    public Ativo toDomain(AtivoEntity entity) {
        if (entity == null) {
            return null;
        }

        Ativo ativo = new Ativo();
        ativo.setId(entity.getId());
        ativo.setMoeda(entity.getMoeda());
        ativo.setValor(entity.getValor());
        return ativo;
    }
}
