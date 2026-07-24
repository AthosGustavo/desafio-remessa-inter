package br.com.remessa.portalbancario.domain.ports.in;

import br.com.remessa.portalbancario.domain.ports.out.command.IniciarRemessaCommand;
import br.com.remessa.portalbancario.domain.ports.result.IniciarRemessaResult;

public interface RemessaUseCase {
    IniciarRemessaResult executar(IniciarRemessaCommand command);
}