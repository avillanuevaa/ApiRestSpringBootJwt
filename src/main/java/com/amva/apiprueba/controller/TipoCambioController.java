package com.amva.apiprueba.controller;

import com.amva.apiprueba.persistence.Entity.TIpoCambio;
import com.amva.apiprueba.service.dto.TIpoCambioINDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.persistence.Entity.TIpoCambio;
import com.amva.apiprueba.service.OperacionCambioMonedaService;
import com.amva.apiprueba.service.dto.OperacionCambioINDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/tipoCambio")
public class TipoCambioController {


    private final OperacionCambioMonedaService operacionservice;

    public TipoCambioController(OperacionCambioMonedaService operacionservice) {
        this.operacionservice = operacionservice;
    }

    @PostMapping
    public TIpoCambio createActualizaTipoCambio(@RequestBody TIpoCambioINDto tIpoCambio) {
        return this.operacionservice.createActualizaTipoCambio(tIpoCambio);
    }

    @GetMapping
    public List<TIpoCambio> listaTipoCambioHistorico(){
        return this.operacionservice.listaTipoCambioHistorico();
    }

    @GetMapping("/cambioVigente")
    public TIpoCambio tipoCambioVigente(){
        return this.operacionservice.tipoCambioVigente();
    }

}
