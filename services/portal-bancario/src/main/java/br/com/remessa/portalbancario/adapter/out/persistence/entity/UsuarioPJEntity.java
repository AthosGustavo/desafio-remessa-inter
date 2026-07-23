package br.com.remessa.portalbancario.adapter.out.persistence.entity;

import br.com.remessa.portalbancario.domain.model.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PJ")
public class UsuarioPJEntity extends UsuarioEntity {
    private String cnpj;

    public UsuarioPJEntity() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
