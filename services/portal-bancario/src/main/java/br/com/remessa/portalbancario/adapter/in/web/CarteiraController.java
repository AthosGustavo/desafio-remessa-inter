package br.com.remessa.portalbancario.adapter.in.web;

import br.com.remessa.portalbancario.adapter.in.web.request.ConsultarSaldoRequest;
import br.com.remessa.portalbancario.adapter.in.web.request.ConsultarSaldoTotalRequest;
import br.com.remessa.portalbancario.adapter.in.web.response.ConsultarSaldoTotalResponse;
import br.com.remessa.portalbancario.domain.ports.in.CarteiraUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CarteiraUseCase carteiraUseCase;

    public CarteiraController(CarteiraUseCase carteiraUseCase) {
        this.carteiraUseCase = carteiraUseCase;
    }

    @PostMapping("/saldo-moeda")
    public ResponseEntity<BigDecimal> consultarSaldoMoeda(@Valid @RequestBody ConsultarSaldoRequest request) {
        BigDecimal saldo = carteiraUseCase.consultarSaldoPorMoeda(request.getDocumento(), request.getSenha(), request.getMoeda()
        );
        return ResponseEntity.ok(saldo);
    }

    @PostMapping("/saldo-total")
    public ResponseEntity<ConsultarSaldoTotalResponse> consultarSaldoTotal(@Valid @RequestBody ConsultarSaldoTotalRequest request) {
        ConsultarSaldoTotalResponse response = carteiraUseCase.consultarSaldoTotal(
                request.getDocumento(),
                request.getSenha()
        );
        return ResponseEntity.ok(response);
    }


}
