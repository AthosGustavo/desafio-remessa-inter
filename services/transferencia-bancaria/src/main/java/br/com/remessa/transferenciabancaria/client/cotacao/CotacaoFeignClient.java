package br.com.remessa.transferenciabancaria.client.cotacao;

import br.com.remessa.transferenciabancaria.client.dto.CotacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cotacao-client", url = "${clients.cotacao.url}")
public interface CotacaoFeignClient {

    @GetMapping("/cotacoes")
    CotacaoResponse consultar(
            @RequestParam("origem") String moedaOrigem,
            @RequestParam("destino") String moedaDestino
    );
}
