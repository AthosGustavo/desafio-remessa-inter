package br.com.remessa.transferenciabancaria.service;
import br.com.remessa.transferenciabancaria.dto.TransferenciaRequest;
import br.com.remessa.transferenciabancaria.dto.TransferenciaResponse;
import br.com.remessa.transferenciabancaria.enums.EnumStatus;
import br.com.remessa.transferenciabancaria.model.TransacaoHistorico;
import br.com.remessa.transferenciabancaria.repository.TransacaoHistoricoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
public class TransferenciaService {

    private final TransacaoHistoricoRepository historicoRepository;
    private final CotacaoService cotacaoService;

    public TransferenciaService(
            TransacaoHistoricoRepository historicoRepository,
            CotacaoService cotacaoService
    ) {
        this.historicoRepository = historicoRepository;
        this.cotacaoService = cotacaoService;
    }

    @Transactional
    public TransferenciaResponse solicitarTransferencia(TransferenciaRequest request) {
        BigDecimal cotacao = cotacaoService.consultar(request.moedaOrigem(), request.moedaDestino());

        BigDecimal valorDestino = request.valorOrigem()
                .multiply(cotacao)
                .setScale(2, RoundingMode.HALF_UP);

        TransacaoHistorico historico = new TransacaoHistorico();
        historico.setUsuarioOrigemId(request.usuarioOrigemId());
        historico.setUsuarioDestinoId(request.usuarioDestinoId());
        historico.setValorOrigem(request.valorOrigem());
        historico.setMoedaOrigem(request.moedaOrigem().getDescricao());
        historico.setValorDestino(valorDestino);
        historico.setMoedaDestino(request.moedaDestino().getDescricao());
        historico.setCotacao(cotacao);
        historico.setStatus(EnumStatus.SUCESSO.getDescricao());
        historico.setData(LocalDateTime.now());

        TransacaoHistorico salvo = historicoRepository.save(historico);

        return new TransferenciaResponse(
                String.valueOf(salvo.getId()),
                salvo.getStatus()
        );
    }
}