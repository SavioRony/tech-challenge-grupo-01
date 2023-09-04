package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.ConsumoModel;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumoRepository extends JpaRepository<ConsumoModel, Long> {


    @Query(value = "Select * from tb_consumo where id_eletrodomestico = :idEletrodomestico", nativeQuery = true)
    Optional<List<ConsumoModel>> findByEletrodomestico(@Param("idEletrodomestico") Long idEletrodomestico);
}
