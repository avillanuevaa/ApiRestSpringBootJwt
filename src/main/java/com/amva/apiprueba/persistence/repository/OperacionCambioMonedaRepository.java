package com.amva.apiprueba.persistence.repository;

import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.persistence.Entity.TipoMoneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperacionCambioMonedaRepository extends JpaRepository<OperacionCambioMoneda, Long> {

   // public List<OperacionCambioMoneda> findAllByTaskStatus(TipoMoneda status);

    @Modifying
    @Query(value = "UPDATE OperacionCambioMoneda SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
