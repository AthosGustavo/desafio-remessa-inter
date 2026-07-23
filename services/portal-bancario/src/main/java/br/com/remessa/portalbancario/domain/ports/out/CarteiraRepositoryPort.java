package br.com.remessa.portalbancario.domain.ports.out;

import br.com.remessa.portalbancario.domain.model.Carteira;

import java.util.Optional;

public interface CarteiraRepositoryPort {
    Carteira salvar(Carteira carteira);
    Optional<Carteira> buscarPorId(Long id);
    Optional<Carteira> buscarPorUsuarioId(Long usuarioId);
    Optional<Carteira> buscarPorDocumento(String documento);
}
