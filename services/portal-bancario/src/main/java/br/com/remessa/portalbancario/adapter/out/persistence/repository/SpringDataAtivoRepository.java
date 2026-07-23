package br.com.remessa.portalbancario.adapter.out.persistence.repository;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.AtivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataAtivoRepository extends JpaRepository<AtivoEntity, Long> {
    Optional<AtivoEntity> findByCarteiraIdAndMoeda(Long carteiraId, String moeda);
}
