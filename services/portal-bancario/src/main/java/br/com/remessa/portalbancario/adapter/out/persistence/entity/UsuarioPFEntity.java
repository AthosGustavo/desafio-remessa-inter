package br.com.remessa.portalbancario.adapter.out.persistence.entity;

import br.com.remessa.portalbancario.domain.model.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PF")
public class UsuarioPFEntity extends UsuarioEntity {
    private String cpf;

    public UsuarioPFEntity() {
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
