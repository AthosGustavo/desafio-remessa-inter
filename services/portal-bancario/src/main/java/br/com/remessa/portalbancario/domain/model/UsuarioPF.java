package br.com.remessa.portalbancario.domain.model;

public class UsuarioPF extends Usuario{

    private String cpf;

    public UsuarioPF() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
