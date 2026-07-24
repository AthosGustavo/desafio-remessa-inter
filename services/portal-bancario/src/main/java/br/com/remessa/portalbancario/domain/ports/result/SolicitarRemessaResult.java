package br.com.remessa.portalbancario.domain.ports.result;

public record SolicitarRemessaResult(
        String remessaId,
        String status
) {}
