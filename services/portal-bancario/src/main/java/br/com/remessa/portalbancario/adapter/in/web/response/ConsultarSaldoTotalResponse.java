package br.com.remessa.portalbancario.adapter.in.web.response;

import java.math.BigDecimal;

public class ConsultarSaldoTotalResponse {

    private BigDecimal saldoReal;
    private BigDecimal saldoDolar;

    public ConsultarSaldoTotalResponse() {
    }

    public ConsultarSaldoTotalResponse(BigDecimal saldoReal, BigDecimal saldoDolar) {
        this.saldoReal = saldoReal;
        this.saldoDolar = saldoDolar;
    }

    public BigDecimal getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(BigDecimal saldoReal) {
        this.saldoReal = saldoReal;
    }

    public BigDecimal getSaldoDolar() {
        return saldoDolar;
    }

    public void setSaldoDolar(BigDecimal saldoDolar) {
        this.saldoDolar = saldoDolar;
    }
}