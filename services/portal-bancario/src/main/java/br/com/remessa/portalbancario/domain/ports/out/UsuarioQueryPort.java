package br.com.remessa.portalbancario.domain.ports.out;

import br.com.remessa.portalbancario.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioQueryPort {
    Optional<Usuario> buscarPorDocumento(String documento);
}
