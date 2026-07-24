package br.com.remessa.transferenciabancaria.client.dto;

import java.math.BigDecimal;

public record CotacaoResponse(
        String origem,
        String destino,
        BigDecimal cotacao
) {}
