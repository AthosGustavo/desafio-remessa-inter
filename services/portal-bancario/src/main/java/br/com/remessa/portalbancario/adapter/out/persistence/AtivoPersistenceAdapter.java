package br.com.remessa.portalbancario.adapter.out.persistence;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.AtivoEntity;
import br.com.remessa.portalbancario.adapter.out.persistence.repository.SpringDataAtivoRepository;
import br.com.remessa.portalbancario.domain.model.Ativo;
import br.com.remessa.portalbancario.domain.ports.out.AtivoRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.Optional;
import br.com.remessa.portalbancario.adapter.out.persistence.entity.CarteiraEntity;
import br.com.remessa.portalbancario.domain.model.Carteira;

@Component
public class AtivoPersistenceAdapter implements AtivoRepositoryPort {

    private final SpringDataAtivoRepository repository;

    public AtivoPersistenceAdapter(SpringDataAtivoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ativo salvar(Ativo ativo) {
        AtivoEntity entity = toEntity(ativo);
        AtivoEntity savedEntity = repository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Ativo> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Ativo> buscarPorCarteiraEMoeda(Long carteiraId, String moeda) {
        return repository.findByCarteiraIdAndMoeda(carteiraId, moeda).map(this::toDomain);
    }

    private AtivoEntity toEntity(Ativo ativo) {
        if (ativo == null) {
            return null;
        }

        AtivoEntity entity = new AtivoEntity();
        entity.setId(ativo.getId());
        entity.setValor(ativo.getValor());

        if (ativo.getMoeda() != null) {
            entity.setMoeda(ativo.getMoeda());
        }

        if (ativo.getCarteira() != null) {
            CarteiraEntity carteiraEntity = new CarteiraEntity();
            carteiraEntity.setId(ativo.getCarteira().getId());
            entity.setCarteira(carteiraEntity);
        }

        return entity;
    }

    private Ativo toDomain(AtivoEntity entity) {
        if (entity == null) {
            return null;
        }

        Ativo ativo = new Ativo();
        ativo.setId(entity.getId());
        ativo.setValor(entity.getValor());

        if (entity.getMoeda() != null) {
            ativo.setMoeda(entity.getMoeda());
        }

        if (entity.getCarteira() != null) {
            Carteira carteira = new Carteira();
            carteira.setId(entity.getCarteira().getId());
            ativo.setCarteira(carteira);
        }

        return ativo;
    }
}

