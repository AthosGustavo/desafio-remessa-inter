package br.com.remessa.portalbancario.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CarteiraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "carteira", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AtivoEntity> ativos = new ArrayList<>();

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AtivoEntity> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<AtivoEntity> ativos) {
        this.ativos = ativos;
    }
}
