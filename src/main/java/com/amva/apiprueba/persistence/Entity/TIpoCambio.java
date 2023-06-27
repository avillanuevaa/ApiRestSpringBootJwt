package com.amva.apiprueba.persistence.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="TipoCambio")
public class TIpoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double valor;
    private LocalDateTime fechaOperacion;
}
