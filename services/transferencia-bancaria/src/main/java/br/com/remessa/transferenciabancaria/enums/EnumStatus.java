package br.com.remessa.transferenciabancaria.enums;

public enum EnumStatus {
    PENDENTE("PENDENTE"),
    SUCESSO("SUCESSO"),
    FALHA("FALHA"),
    ESTORNADA("ESTORNADA");

    private final String descricao;

    EnumStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}