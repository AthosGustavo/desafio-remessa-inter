package br.com.remessa.transferenciabancaria.model;

import br.com.remessa.transferenciabancaria.enums.EnumMoeda;
import br.com.remessa.transferenciabancaria.enums.EnumStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao_historico")
public class TransacaoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_origem_id", nullable = false)
    private Long usuarioOrigemId;

    @Column(name = "usuario_destino_id", nullable = false)
    private Long usuarioDestinoId;

    @Column(name = "valor_origem", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorOrigem;

    @Enumerated(EnumType.STRING)
    @Column(name = "moeda_origem", nullable = false, length = 10)
    private String moedaOrigem;

    @Column(name = "valor_destino", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorDestino;

    @Enumerated(EnumType.STRING)
    @Column(name = "moeda_destino", nullable = false, length = 10)
    private String moedaDestino;

    @Column(name = "cotacao", nullable = false, precision = 19, scale = 6)
    private BigDecimal cotacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    public Long getId() { return id; }
    public Long getUsuarioOrigemId() { return usuarioOrigemId; }
    public Long getUsuarioDestinoId() { return usuarioDestinoId; }
    public BigDecimal getValorOrigem() { return valorOrigem; }
    public String getMoedaOrigem() { return moedaOrigem; }
    public BigDecimal getValorDestino() { return valorDestino; }
    public String getMoedaDestino() { return moedaDestino; }
    public BigDecimal getCotacao() { return cotacao; }
    public String getStatus() { return status; }
    public LocalDateTime getData() { return data; }

    public void setId(Long id) { this.id = id; }
    public void setUsuarioOrigemId(Long usuarioOrigemId) { this.usuarioOrigemId = usuarioOrigemId; }
    public void setUsuarioDestinoId(Long usuarioDestinoId) { this.usuarioDestinoId = usuarioDestinoId; }
    public void setValorOrigem(BigDecimal valorOrigem) { this.valorOrigem = valorOrigem; }
    public void setMoedaOrigem(String moedaOrigem) { this.moedaOrigem = moedaOrigem; }
    public void setValorDestino(BigDecimal valorDestino) { this.valorDestino = valorDestino; }
    public void setMoedaDestino(String moedaDestino) { this.moedaDestino = moedaDestino; }
    public void setCotacao(BigDecimal cotacao) { this.cotacao = cotacao; }
    public void setStatus(String status) { this.status = status; }
    public void setData(LocalDateTime data) { this.data = data; }
}
