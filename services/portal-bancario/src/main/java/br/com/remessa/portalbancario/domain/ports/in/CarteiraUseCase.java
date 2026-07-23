package br.com.remessa.portalbancario.domain.ports.in;

import br.com.remessa.portalbancario.adapter.in.web.response.ConsultarSaldoTotalResponse;
import br.com.remessa.portalbancario.domain.model.Carteira;
import br.com.remessa.portalbancario.domain.model.EnumMoeda;
import br.com.remessa.portalbancario.domain.model.Usuario;

import java.math.BigDecimal;

public interface CarteiraUseCase {
    BigDecimal consultarSaldoPorMoeda(String documento, String senha, EnumMoeda moeda);
    Carteira depositar(String documento,String senha,EnumMoeda moedaOrigem,BigDecimal valorMoedaOrigem, EnumMoeda moedaDestino);
    ConsultarSaldoTotalResponse consultarSaldoTotal(String documento, String senha);
}
