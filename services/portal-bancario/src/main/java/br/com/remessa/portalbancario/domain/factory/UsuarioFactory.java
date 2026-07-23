package br.com.remessa.portalbancario.domain.factory;

import br.com.remessa.portalbancario.adapter.in.web.request.CadastrarUsuarioRequest;
import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoUtils;
import br.com.remessa.portalbancario.domain.model.Usuario;
import br.com.remessa.portalbancario.domain.model.UsuarioPF;
import br.com.remessa.portalbancario.domain.model.UsuarioPJ;

public final class UsuarioFactory {

    private UsuarioFactory() {
    }

    public static Usuario criar(CadastrarUsuarioRequest request) {
        String documentoLimpo = DocumentoUtils.somenteDigitos(request.getDocumento());

        if (DocumentoUtils.isCpf(documentoLimpo)) {
            UsuarioPF usuario = new UsuarioPF();
            usuario.setNome(request.getNome());
            usuario.setEmail(request.getEmail());
            usuario.setSenha(request.getSenha());
            usuario.setCpf(documentoLimpo);
            return usuario;
        }

        if (DocumentoUtils.isCnpj(documentoLimpo)) {
            UsuarioPJ usuario = new UsuarioPJ();
            usuario.setNome(request.getNome());
            usuario.setEmail(request.getEmail());
            usuario.setSenha(request.getSenha());
            usuario.setCnpj(documentoLimpo);
            return usuario;
        }

        throw new IllegalArgumentException("Documento inválido");
    }
}