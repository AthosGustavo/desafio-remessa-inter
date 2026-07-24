package br.com.remessa.portalbancario.adapter.out.integration.feign;

import br.com.remessa.portalbancario.adapter.in.web.request.RemessaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "transferencia-bancaria-sv",
        path = "/transferencias"
)
public interface TransferenciaBancariaFeignClient {

    @PostMapping
    TransferenciaResponseFeign solicitarTransferencia(@RequestBody RemessaRequest request);
}
