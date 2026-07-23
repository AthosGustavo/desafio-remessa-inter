package br.com.remessa.portalbancario.adapter.out.persistence.mapper;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.AtivoEntity;
import br.com.remessa.portalbancario.adapter.out.persistence.entity.CarteiraEntity;
import br.com.remessa.portalbancario.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarteiraPersistenceMapper {

    private final UsuarioPersistenceMapper usuarioMapper;
    private final AtivoPersistenceMapper ativoMapper;

    public CarteiraPersistenceMapper(UsuarioPersistenceMapper usuarioMapper, AtivoPersistenceMapper ativoMapper) {
        this.usuarioMapper = usuarioMapper;
        this.ativoMapper = ativoMapper;
    }

    public CarteiraEntity toEntity(Carteira carteira) {
        if (carteira == null) {
            return null;
        }

        CarteiraEntity entity = new CarteiraEntity();
        entity.setId(carteira.getId());
        entity.setUsuario(usuarioMapper.toEntity(carteira.getUsuario()));

        List<AtivoEntity> ativos = carteira.getAtivos().stream()
                .map(ativoMapper::toEntity)
                .toList();

        ativos.forEach(ativo -> ativo.setCarteira(entity));
        entity.setAtivos(ativos);

        return entity;
    }

    public Carteira toDomain(CarteiraEntity entity) {
        if (entity == null) {
            return null;
        }

        Carteira carteira = new Carteira();
        carteira.setId(entity.getId());
        carteira.setUsuario(usuarioMapper.toDomain(entity.getUsuario()));

        List<Ativo> ativos = entity.getAtivos().stream()
                .map(ativoMapper::toDomain)
                .toList();

        ativos.forEach(ativo -> ativo.setCarteira(carteira));
        carteira.setAtivos(ativos);

        return carteira;
    }
}