package br.com.remessa.portalbancario.domain.ports.out.command;

import br.com.remessa.portalbancario.domain.model.EnumMoeda;

import java.math.BigDecimal;

public record SolicitarRemessaCommand(
        Long usuarioOrigemId,
        Long usuarioDestinoId,
        BigDecimal valorOrigem,
        EnumMoeda moedaOrigem,
        EnumMoeda moedaDestino
) {}
