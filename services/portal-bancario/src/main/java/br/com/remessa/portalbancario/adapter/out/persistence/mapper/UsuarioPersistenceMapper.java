package br.com.remessa.portalbancario.adapter.out.persistence.mapper;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.UsuarioEntity;
import br.com.remessa.portalbancario.adapter.out.persistence.entity.UsuarioPFEntity;
import br.com.remessa.portalbancario.adapter.out.persistence.entity.UsuarioPJEntity;
import br.com.remessa.portalbancario.domain.model.Usuario;
import br.com.remessa.portalbancario.domain.model.UsuarioPF;
import br.com.remessa.portalbancario.domain.model.UsuarioPJ;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPersistenceMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        if (usuario instanceof UsuarioPF usuarioPF) {
            UsuarioPFEntity entity = new UsuarioPFEntity();
            entity.setId(usuarioPF.getId());
            entity.setNome(usuarioPF.getNome());
            entity.setEmail(usuarioPF.getEmail());
            entity.setSenha(usuarioPF.getSenha());
            entity.setCpf(usuarioPF.getCpf());
            return entity;
        }

        if (usuario instanceof UsuarioPJ usuarioPJ) {
            UsuarioPJEntity entity = new UsuarioPJEntity();
            entity.setId(usuarioPJ.getId());
            entity.setNome(usuarioPJ.getNome());
            entity.setEmail(usuarioPJ.getEmail());
            entity.setSenha(usuarioPJ.getSenha());
            entity.setCnpj(usuarioPJ.getCnpj());
            return entity;
        }

        throw new IllegalArgumentException("Tipo de usuário não suportado: " + usuario.getClass().getName());
    }

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        if (entity instanceof UsuarioPFEntity usuarioPFEntity) {
            UsuarioPF usuario = new UsuarioPF();
            usuario.setId(usuarioPFEntity.getId());
            usuario.setNome(usuarioPFEntity.getNome());
            usuario.setEmail(usuarioPFEntity.getEmail());
            usuario.setSenha(usuarioPFEntity.getSenha());
            usuario.setCpf(usuarioPFEntity.getCpf());
            return usuario;
        }

        if (entity instanceof UsuarioPJEntity usuarioPJEntity) {
            UsuarioPJ usuario = new UsuarioPJ();
            usuario.setId(usuarioPJEntity.getId());
            usuario.setNome(usuarioPJEntity.getNome());
            usuario.setEmail(usuarioPJEntity.getEmail());
            usuario.setSenha(usuarioPJEntity.getSenha());
            usuario.setCnpj(usuarioPJEntity.getCnpj());
            return usuario;
        }

        throw new IllegalArgumentException("Tipo de entidade de usuário não suportado: " + entity.getClass().getName());
    }
}
