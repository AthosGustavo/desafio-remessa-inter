package br.com.remessa.transferenciabancaria.dto;

import br.com.remessa.transferenciabancaria.enums.EnumMoeda;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferenciaRequest(
        @NotNull Long usuarioOrigemId,
        @NotNull Long usuarioDestinoId,
        @NotNull @DecimalMin(value = "0.01") BigDecimal valorOrigem,
        @NotNull EnumMoeda moedaOrigem,
        @NotNull EnumMoeda moedaDestino
) {}