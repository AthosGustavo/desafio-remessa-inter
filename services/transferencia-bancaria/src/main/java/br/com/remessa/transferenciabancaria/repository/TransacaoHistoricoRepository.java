package br.com.remessa.transferenciabancaria.repository;

import br.com.remessa.transferenciabancaria.model.TransacaoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoHistoricoRepository extends JpaRepository<TransacaoHistorico, Long> {
}