package br.com.remessa.portalbancario.adapter.in.web;

import br.com.remessa.portalbancario.adapter.in.web.request.RemessaRequest;
import br.com.remessa.portalbancario.domain.ports.in.RemessaUseCase;
import br.com.remessa.portalbancario.domain.ports.out.command.IniciarRemessaCommand;
import br.com.remessa.portalbancario.domain.ports.result.IniciarRemessaResult;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remessas")
public class RemessaController {

    private final RemessaUseCase useCase;

    public RemessaController(RemessaUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public IniciarRemessaResult iniciar(@RequestBody @Valid RemessaRequest req) {
        return useCase.executar(new IniciarRemessaCommand(
                req.documentoOrigem(),
                req.senhaOrigem(),
                req.documentoDestino(),
                req.valorOrigem(),
                req.moedaOrigem(),
                req.moedaDestino()
        ));
    }
}