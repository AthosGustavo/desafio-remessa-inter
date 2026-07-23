package br.com.remessa.portalbancario.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private Long id;
    private Usuario usuario;
    private List<Ativo> ativos = new ArrayList<>();

    public Carteira() {}

    public Carteira(Usuario usuario) {
        this.usuario = usuario;
        this.ativos.add(new Ativo(EnumMoeda.BRL, BigDecimal.ZERO));
        this.ativos.add(new Ativo(EnumMoeda.USD, BigDecimal.ZERO));
    }

    public BigDecimal obterValorTotal() {
        return ativos.stream()
                .map(Ativo::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal obterSaldoPorMoeda(EnumMoeda moeda) {
        return ativos.stream()
                .filter(a -> a.getMoeda().equals(moeda))
                .findFirst()
                .map(Ativo::getValor)
                .orElse(BigDecimal.ZERO);
    }

    public void depositar(EnumMoeda moeda, BigDecimal valorAdicional) {
        if (valorAdicional.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo");
        }

        Ativo ativo = ativos.stream()
                .filter(a -> a.getMoeda().equals(moeda))
                .findFirst()
                .orElseGet(() -> {
                    Ativo novoAtivo = new Ativo(moeda, BigDecimal.ZERO);
                    ativos.add(novoAtivo);
                    return novoAtivo;
                });

        ativo.setValor(ativo.getValor().add(valorAdicional));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public List<Ativo> getAtivos() { return ativos; }
    public void setAtivos(List<Ativo> ativos) { this.ativos = ativos; }
}