package br.com.remessa.portalbancario.application.usecase;

import br.com.remessa.portalbancario.domain.model.Usuario;
import br.com.remessa.portalbancario.domain.ports.in.UsuarioUseCase;
import br.com.remessa.portalbancario.domain.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioUseCase {

    private final UsuarioRepositoryPort repositoryPort;

    public UsuarioService(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositoryPort.salvar(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        return repositoryPort.salvar(usuario);
    }

    @Override
    public void excluirUsuario(Long id) {
        repositoryPort.deletar(id);
    }
}
