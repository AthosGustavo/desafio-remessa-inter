package br.com.remessa.transferenciabancaria.enums;

public enum EnumMoeda {
    BRL("BRL"),
    USD("USD");

    private final String descricao;

    EnumMoeda(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
