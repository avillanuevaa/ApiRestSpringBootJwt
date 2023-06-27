package com.amva.apiprueba.service.dto;

import com.amva.apiprueba.persistence.Entity.TipoMoneda;
import lombok.Data;

@Data
public class OperacionCambioINDto {
    private double monto;
    private TipoMoneda monedaOrigen;
    private TipoMoneda monedaDestino;
}
