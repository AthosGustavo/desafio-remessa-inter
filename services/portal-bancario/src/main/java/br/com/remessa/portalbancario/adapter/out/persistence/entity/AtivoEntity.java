package br.com.remessa.portalbancario.adapter.out.persistence.entity;

import br.com.remessa.portalbancario.domain.model.EnumMoeda;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class AtivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumMoeda moeda;

    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carteira_id")
    private CarteiraEntity carteira;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumMoeda getMoeda() {
        return moeda;
    }

    public void setMoeda(EnumMoeda moeda) {
        this.moeda = moeda;
    }

    public CarteiraEntity getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraEntity carteira) {
        this.carteira = carteira;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
