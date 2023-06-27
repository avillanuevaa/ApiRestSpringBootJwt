package com.amva.apiprueba.persistence.repository;

import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.persistence.Entity.TIpoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioRepository extends JpaRepository<TIpoCambio, Long> {
}
