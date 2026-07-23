package br.com.remessa.portalbancario.adapter.in.web.request;

import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoValido;
import jakarta.validation.constraints.NotBlank;

public class ConsultarSaldoTotalRequest {

    @NotBlank(message = "O documento é obrigatório")
    @DocumentoValido
    private String documento;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

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
}