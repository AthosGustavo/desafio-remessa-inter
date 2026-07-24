package br.com.remessa.portalbancario.adapter.out.integration;

import br.com.remessa.portalbancario.adapter.out.integration.feign.TransferenciaBancariaFeignClient;
import br.com.remessa.portalbancario.domain.ports.out.TransferenciaBancariaClientPort;
import br.com.remessa.portalbancario.domain.ports.out.command.SolicitarRemessaCommand;
import br.com.remessa.portalbancario.domain.ports.result.SolicitarRemessaResult;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaBancariaClientAdapter implements TransferenciaBancariaClientPort {

    private final TransferenciaBancariaFeignClient feignClient;

    public TransferenciaBancariaClientAdapter(TransferenciaBancariaFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public SolicitarRemessaResult solicitarRemessa(SolicitarRemessaCommand command) {
        var response = feignClient.solicitarTransferencia(new TransferenciaRequestFeign(
                command.usuarioOrigemId(),
                command.usuarioDestinoId(),
                command.valorOrigem(),
                command.moedaOrigem(),
                command.moedaDestino()
        ));

        return new SolicitarRemessaResult(response.remessaId(), response.status());
    }
}
