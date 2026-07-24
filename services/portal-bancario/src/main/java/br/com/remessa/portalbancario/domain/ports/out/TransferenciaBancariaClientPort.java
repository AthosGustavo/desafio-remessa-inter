package br.com.remessa.portalbancario.domain.ports.out;

import br.com.remessa.portalbancario.adapter.in.web.request.RemessaRequest;
import br.com.remessa.portalbancario.adapter.in.web.response.RemessaResponse;
import br.com.remessa.portalbancario.domain.ports.out.command.SolicitarRemessaCommand;
import br.com.remessa.portalbancario.domain.ports.result.SolicitarRemessaResult;

public interface TransferenciaBancariaClientPort {
    SolicitarRemessaResult solicitarRemessa(SolicitarRemessaCommand command);
}