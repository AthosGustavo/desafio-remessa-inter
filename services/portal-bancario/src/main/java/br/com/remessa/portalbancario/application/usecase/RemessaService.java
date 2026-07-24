package br.com.remessa.portalbancario.application.usecase;

import br.com.remessa.portalbancario.adapter.in.web.request.RemessaRequest;
import br.com.remessa.portalbancario.adapter.in.web.response.RemessaResponse;
import br.com.remessa.portalbancario.adapter.in.web.validacao.DocumentoValidator;
import br.com.remessa.portalbancario.domain.model.Usuario;
import br.com.remessa.portalbancario.domain.ports.in.RemessaUseCase;
import br.com.remessa.portalbancario.domain.ports.out.SaldoQueryPort;
import br.com.remessa.portalbancario.domain.ports.out.SenhaPort;
import br.com.remessa.portalbancario.domain.ports.out.TransferenciaBancariaClientPort;
import br.com.remessa.portalbancario.domain.ports.out.UsuarioQueryPort;
import br.com.remessa.portalbancario.domain.ports.out.command.IniciarRemessaCommand;
import br.com.remessa.portalbancario.domain.ports.out.command.SolicitarRemessaCommand;
import br.com.remessa.portalbancario.domain.ports.result.IniciarRemessaResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RemessaService implements RemessaUseCase {

    private final DocumentoValidator documentoValidator;
    private final UsuarioQueryPort usuarioQueryPort;
    private final SenhaPort senhaPort;
    private final SaldoQueryPort saldoQueryPort;
    private final TransferenciaBancariaClientPort transferenciaBancariaClientPort;

    public RemessaService(
            DocumentoValidator documentoValidator,
            UsuarioQueryPort usuarioQueryPort,
            SenhaPort senhaPort,
            SaldoQueryPort saldoQueryPort,
            TransferenciaBancariaClientPort transferenciaBancariaClientPort
    ) {
        this.documentoValidator = documentoValidator;
        this.usuarioQueryPort = usuarioQueryPort;
        this.senhaPort = senhaPort;
        this.saldoQueryPort = saldoQueryPort;
        this.transferenciaBancariaClientPort = transferenciaBancariaClientPort;
    }

    @Override
    public IniciarRemessaResult executar(IniciarRemessaCommand command) {
        if (!documentoValidator.documentoValido(command.documentoOrigem())) {
            throw new IllegalArgumentException("Documento de origem inválido");
        }

        if (!documentoValidator.documentoValido(command.documentoDestino())) {
            throw new IllegalArgumentException("Documento de destino inválido");
        }

        Usuario origem = usuarioQueryPort.buscarPorDocumento(command.documentoOrigem())
                .orElseThrow(() -> new IllegalArgumentException("Usuário de origem não encontrado"));

        Usuario destino = usuarioQueryPort.buscarPorDocumento(command.documentoDestino())
                .orElseThrow(() -> new IllegalArgumentException("Usuário de destino não encontrado"));

        if (origem.getId().equals(destino.getId())) {
            throw new IllegalArgumentException("Origem e destino não podem ser o mesmo usuário");
        }

        if (!senhaPort.confere(command.senhaOrigem(), origem.getSenha())) {
            throw new IllegalArgumentException("Senha inválida");
        }

        BigDecimal saldoAtual = saldoQueryPort.obterSaldoPorUsuarioEMoeda(origem.getId(), command.moedaOrigem());
        if (saldoAtual.compareTo(command.valorOrigem()) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        var resposta = transferenciaBancariaClientPort.solicitarRemessa(new SolicitarRemessaCommand(
                origem.getId(),
                destino.getId(),
                command.valorOrigem(),
                command.moedaOrigem(),
                command.moedaDestino()
        ));

        return new IniciarRemessaResult(resposta.remessaId(), resposta.status());
    }
}
