package br.com.remessa.portalbancario.domain.ports.in;

import br.com.remessa.portalbancario.domain.model.Usuario;

public interface UsuarioUseCase {
    Usuario cadastrarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Long id, Usuario usuario);
    void excluirUsuario(Long id);
}
