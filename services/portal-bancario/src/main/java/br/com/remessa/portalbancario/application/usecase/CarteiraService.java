package br.com.remessa.portalbancario.application.usecase;

import br.com.remessa.portalbancario.adapter.in.web.response.ConsultarSaldoTotalResponse;
import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoUtils;
import br.com.remessa.portalbancario.domain.model.*;
import br.com.remessa.portalbancario.domain.ports.in.CarteiraUseCase;
import br.com.remessa.portalbancario.domain.ports.out.CarteiraRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CarteiraService implements CarteiraUseCase {

    private final CarteiraRepositoryPort repositoryPort;

    public CarteiraService(CarteiraRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public BigDecimal consultarSaldoPorMoeda(String documento, String senha, EnumMoeda moeda) {
        Carteira carteira = buscarCarteiraOuLancarExcecao(documento, senha);
        return carteira.obterSaldoPorMoeda(moeda);
    }



    @Override
    public ConsultarSaldoTotalResponse consultarSaldoTotal(String documento, String senha) {
        Carteira carteira = buscarCarteiraOuLancarExcecao(documento, senha);
        BigDecimal saldoReal = carteira.obterSaldoPorMoeda(EnumMoeda.BRL);
        BigDecimal saldoDolar = carteira.obterSaldoPorMoeda(EnumMoeda.USD);
        return new ConsultarSaldoTotalResponse(saldoReal, saldoDolar);
    }

    private Carteira buscarCarteiraOuLancarExcecao(String documento, String senha) {
        if (!DocumentoUtils.isDocumentoValido(documento)) {
            throw new RuntimeException("Documento inválido");
        }

        String documentoLimpo = DocumentoUtils.somenteDigitos(documento);

        Carteira carteira = repositoryPort.buscarPorDocumento(documentoLimpo)
                .orElseThrow(RuntimeException::new);

        if (carteira.getUsuario() == null) {
            throw new RuntimeException("Usuário da carteira não encontrado");
        }

        Usuario usuario = carteira.getUsuario();

        boolean documentoConfere = false;

        if (usuario instanceof UsuarioPF usuarioPF) {
            documentoConfere = usuarioPF.getCpf() != null
                    && usuarioPF.getCpf().equals(documentoLimpo);
        } else if (usuario instanceof UsuarioPJ usuarioPJ) {
            documentoConfere = usuarioPJ.getCnpj() != null
                    && usuarioPJ.getCnpj().equals(documentoLimpo);
        }

        boolean senhaConfere = usuario.getSenha() != null
                && usuario.getSenha().equals(senha);

        if (!documentoConfere || !senhaConfere) {
            throw new RuntimeException("Documento ou senha inválidos");
        }
        return carteira;
    }

    private BigDecimal simularConversao(EnumMoeda moedaOrigem, BigDecimal valorOrigem,EnumMoeda moedaDestino) {
        return valorOrigem;
    }
}
