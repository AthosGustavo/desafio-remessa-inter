package br.com.remessa.portalbancario.domain.ports.out.command;

import br.com.remessa.portalbancario.domain.model.EnumMoeda;

import java.math.BigDecimal;

public record IniciarRemessaCommand(
        String documentoOrigem,
        String senhaOrigem,
        String documentoDestino,
        BigDecimal valorOrigem,
        EnumMoeda moedaOrigem,
        EnumMoeda moedaDestino
) {}