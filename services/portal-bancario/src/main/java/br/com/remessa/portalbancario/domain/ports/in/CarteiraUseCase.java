package br.com.remessa.portalbancario.domain.ports.in;

import br.com.remessa.portalbancario.adapter.in.web.response.ConsultarSaldoTotalResponse;
import br.com.remessa.portalbancario.domain.model.Carteira;
import br.com.remessa.portalbancario.domain.model.EnumMoeda;
import br.com.remessa.portalbancario.domain.model.Usuario;

import java.math.BigDecimal;

public interface CarteiraUseCase {
    BigDecimal consultarSaldoPorMoeda(String documento, String senha, EnumMoeda moeda);
    ConsultarSaldoTotalResponse consultarSaldoTotal(String documento, String senha);
}
