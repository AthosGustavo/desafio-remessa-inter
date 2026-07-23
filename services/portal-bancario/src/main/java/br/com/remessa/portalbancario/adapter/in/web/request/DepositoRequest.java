package br.com.remessa.portalbancario.adapter.in.web.request;

import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoValido;
import br.com.remessa.portalbancario.domain.model.EnumMoeda;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DepositoRequest {

    @NotBlank(message = "O documento é obrigatório")
    @DocumentoValido
    private String documento;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @NotNull(message = "A moeda de origem é obrigatória")
    private EnumMoeda moedaOrigem;

    @NotNull(message = "O valor de origem é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private BigDecimal valorMoedaOrigem;

    @NotNull(message = "A moeda de destino é obrigatória")
    private EnumMoeda moedaDestino;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EnumMoeda getMoedaOrigem() {
        return moedaOrigem;
    }

    public void setMoedaOrigem(EnumMoeda moedaOrigem) {
        this.moedaOrigem = moedaOrigem;
    }

    public BigDecimal getValorMoedaOrigem() {
        return valorMoedaOrigem;
    }

    public void setValorMoedaOrigem(BigDecimal valorMoedaOrigem) {
        this.valorMoedaOrigem = valorMoedaOrigem;
    }

    public EnumMoeda getMoedaDestino() {
        return moedaDestino;
    }

    public void setMoedaDestino(EnumMoeda moedaDestino) {
        this.moedaDestino = moedaDestino;
    }
}