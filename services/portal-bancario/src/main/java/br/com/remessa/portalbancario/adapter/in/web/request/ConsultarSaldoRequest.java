package br.com.remessa.portalbancario.adapter.in.web.request;

import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoValido;
import br.com.remessa.portalbancario.domain.model.EnumMoeda;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConsultarSaldoRequest {

    @NotBlank(message = "O documento é obrigatório")
    @DocumentoValido
    private String documento;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @NotNull(message = "A moeda é obrigatória")
    private EnumMoeda moeda;

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

    public EnumMoeda getMoeda() {
        return moeda;
    }

    public void setMoeda(EnumMoeda moeda) {
        this.moeda = moeda;
    }
}
