package br.com.remessa.portalbancario.adapter.out.persistence.repository;

import br.com.remessa.portalbancario.adapter.out.persistence.entity.CarteiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataCarteiraRepository extends JpaRepository<CarteiraEntity, Long> {

    Optional<CarteiraEntity> findByUsuario_Id(Long usuarioId);

    @Query("""
           select c
           from CarteiraEntity c
           where treat(c.usuario as UsuarioPFEntity).cpf = :cpf
           """)
    Optional<CarteiraEntity> findByUsuarioCpf(String cpf);

    @Query("""
           select c
           from CarteiraEntity c
           where treat(c.usuario as UsuarioPJEntity).cnpj = :cnpj
           """)
    Optional<CarteiraEntity> findByUsuarioCnpj(String cnpj);
}
