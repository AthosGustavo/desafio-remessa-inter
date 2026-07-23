package br.com.remessa.portalbancario.adapter.out.persistence;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.CarteiraEntity;
import br.com.remessa.portalbancario.adapter.out.persistence.mapper.CarteiraPersistenceMapper;
import br.com.remessa.portalbancario.adapter.out.persistence.repository.SpringDataCarteiraRepository;
import br.com.remessa.portalbancario.domain.model.Carteira;
import br.com.remessa.portalbancario.domain.ports.out.CarteiraRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarteiraPersistenceAdapter implements CarteiraRepositoryPort {

    private final SpringDataCarteiraRepository repository;
    private final CarteiraPersistenceMapper mapper;

    public CarteiraPersistenceAdapter(SpringDataCarteiraRepository repository, CarteiraPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Carteira salvar(Carteira carteira) {
        CarteiraEntity entity = mapper.toEntity(carteira);
        CarteiraEntity salva = repository.save(entity);
        return mapper.toDomain(salva);
    }

    @Override
    public Optional<Carteira> buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Carteira> buscarPorUsuarioId(Long usuarioId) {
        return repository.findByUsuario_Id(usuarioId).map(mapper::toDomain);
    }

    @Override
    public Optional<Carteira> buscarPorDocumento(String documento) {
        Optional<CarteiraEntity> carteiraEntity;

        if (documento.length() == 11) {
            carteiraEntity = repository.findByUsuarioCpf(documento);
        } else if (documento.length() == 14) {
            carteiraEntity = repository.findByUsuarioCnpj(documento);
        } else {
            return Optional.empty();
        }

        return carteiraEntity.map(mapper::toDomain);
    }
}
