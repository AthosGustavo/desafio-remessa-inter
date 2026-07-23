package br.com.remessa.portalbancario.domain.ports.out;

import br.com.remessa.portalbancario.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    void deletar(Long id);
}
