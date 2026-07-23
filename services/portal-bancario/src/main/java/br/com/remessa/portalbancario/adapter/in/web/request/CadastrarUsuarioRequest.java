package br.com.remessa.portalbancario.adapter.in.web.request;

import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoValido;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CadastrarUsuarioRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    @Size(max = 150, message = "O email deve ter no máximo 150 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
    private String senha;

    @NotBlank(message = "O documento é obrigatório")
    @DocumentoValido
    private String documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}