package br.com.remessa.portalbancario.domain.model;

public class UsuarioPJ extends Usuario{

    private String cnpj;

    public UsuarioPJ() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
