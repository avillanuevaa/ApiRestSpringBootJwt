package com.amva.apiprueba.persistence.Entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="OperacioCambioMoneda")
public class OperacionCambioMoneda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double monto;
    private TipoMoneda monedaOrigen;
    private TipoMoneda monedaDestino;
    private double montoConTIpoCambio;
    private double tipoCambio;
    private LocalDateTime fechaOperacion;
}
