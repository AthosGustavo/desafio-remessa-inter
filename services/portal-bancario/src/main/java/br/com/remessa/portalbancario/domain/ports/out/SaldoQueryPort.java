package br.com.remessa.portalbancario.domain.ports.out;

import br.com.remessa.portalbancario.domain.model.EnumMoeda;

import java.math.BigDecimal;

public interface SaldoQueryPort {
    BigDecimal obterSaldoPorUsuarioEMoeda(Long usuarioId, EnumMoeda moeda);
}
