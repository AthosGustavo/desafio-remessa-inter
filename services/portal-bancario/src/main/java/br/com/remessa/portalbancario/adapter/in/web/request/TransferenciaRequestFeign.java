package br.com.remessa.portalbancario.adapter.in.web.request;

import br.com.remessa.portalbancario.domain.model.EnumMoeda;

import java.math.BigDecimal;

public record TransferenciaRequestFeign(
        Long usuarioOrigemId,
        Long usuarioDestinoId,
        BigDecimal valorOrigem,
        EnumMoeda moedaOrigem,
        EnumMoeda moedaDestino
) {}
