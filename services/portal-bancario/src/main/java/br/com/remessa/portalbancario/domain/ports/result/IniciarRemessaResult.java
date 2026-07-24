package br.com.remessa.portalbancario.domain.ports.result;

public record IniciarRemessaResult(
        String remessaId,
        String status
) {}
