package br.com.remessa.portalbancario.domain.model;

import java.math.BigDecimal;

public class Ativo {
    private Long id;
    private EnumMoeda moeda;
    private BigDecimal valor;
    private Carteira carteira;

    public Ativo(EnumMoeda moeda, BigDecimal valor) {
        this.moeda = moeda;
        this.valor = valor;
    }
    public Ativo() {

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public EnumMoeda getMoeda() { return moeda; }
    public void setMoeda(EnumMoeda moeda) { this.moeda = moeda; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public Carteira getCarteira() { return carteira; }
    public void setCarteira(Carteira carteira) { this.carteira = carteira;}
}
