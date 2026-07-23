package br.com.remessa.portalbancario.adapter.in.web;

import br.com.remessa.portalbancario.adapter.in.web.request.CadastrarUsuarioRequest;
import br.com.remessa.portalbancario.domain.factory.UsuarioFactory;
import br.com.remessa.portalbancario.domain.model.Usuario;
import br.com.remessa.portalbancario.domain.ports.in.UsuarioUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody CadastrarUsuarioRequest request) {
        Usuario usuario = UsuarioFactory.criar(request);
        return ResponseEntity.ok(usuarioUseCase.cadastrarUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioUseCase.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
