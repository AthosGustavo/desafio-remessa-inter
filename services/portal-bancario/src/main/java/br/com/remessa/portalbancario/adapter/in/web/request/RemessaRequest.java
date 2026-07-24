package br.com.remessa.portalbancario.adapter.in.web.request;

import br.com.remessa.portalbancario.domain.model.EnumMoeda;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RemessaRequest(
        @NotBlank String documentoOrigem,
        @NotBlank String senhaOrigem,
        @NotBlank String documentoDestino,
        @NotNull @DecimalMin(value = "0.01") BigDecimal valorOrigem,
        @NotNull EnumMoeda moedaOrigem,
        @NotNull EnumMoeda moedaDestino
) {}