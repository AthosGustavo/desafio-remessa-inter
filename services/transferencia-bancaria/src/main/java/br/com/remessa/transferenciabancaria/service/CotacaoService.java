package br.com.remessa.transferenciabancaria.service;


import br.com.remessa.transferenciabancaria.client.cotacao.CotacaoFeignClient;
import br.com.remessa.transferenciabancaria.enums.EnumMoeda;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CotacaoService {

    private final CotacaoFeignClient cotacaoFeignClient;

    public CotacaoService(CotacaoFeignClient cotacaoFeignClient) {
        this.cotacaoFeignClient = cotacaoFeignClient;
    }

    public BigDecimal consultar(EnumMoeda origem, EnumMoeda destino) {
        if (origem == destino) {
            return BigDecimal.ONE;
        }

        var response = cotacaoFeignClient.consultar(origem.name(), destino.name());

        if (response == null || response.cotacao() == null || response.cotacao().signum() <= 0) {
            throw new IllegalArgumentException("Cotação inválida para o par " + origem + "/" + destino);
        }

        return response.cotacao();
    }
}