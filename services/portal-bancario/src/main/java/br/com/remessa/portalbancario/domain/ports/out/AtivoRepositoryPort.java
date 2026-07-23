package br.com.remessa.portalbancario.domain.ports.out;

import br.com.remessa.portalbancario.domain.model.Ativo;

import java.util.Optional;

public interface AtivoRepositoryPort {
    Ativo salvar(Ativo ativo);
    Optional<Ativo> buscarPorId(Long id);
    Optional<Ativo> buscarPorCarteiraEMoeda(Long carteiraId, String moeda);
}
