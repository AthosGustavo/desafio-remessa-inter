package br.com.remessa.portalbancario.adapter.out.persistence;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.UsuarioEntity;
import br.com.remessa.portalbancario.adapter.out.persistence.mapper.UsuarioPersistenceMapper;
import br.com.remessa.portalbancario.adapter.out.persistence.repository.SpringDataUsuarioRepository;
import br.com.remessa.portalbancario.domain.model.Usuario;
import br.com.remessa.portalbancario.domain.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final SpringDataUsuarioRepository repository;
    private final UsuarioPersistenceMapper mapper;

    public UsuarioPersistenceAdapter(SpringDataUsuarioRepository repository,
                                     UsuarioPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        UsuarioEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}