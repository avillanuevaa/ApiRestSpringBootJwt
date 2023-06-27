package com.amva.apiprueba.controller;

import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.persistence.Entity.TIpoCambio;
import com.amva.apiprueba.service.OperacionCambioMonedaService;
import com.amva.apiprueba.service.dto.OperacionCambioINDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class OperacionCambioController {

    private final OperacionCambioMonedaService operacionservice;

    public OperacionCambioController(OperacionCambioMonedaService operacionservice) {
        this.operacionservice = operacionservice;
    }

    @PostMapping
    public OperacionCambioMoneda createOperacion(@RequestBody OperacionCambioINDto opeINDto) {
        return this.operacionservice.createOperacionCambioMoneda(opeINDto);
    }


    @GetMapping
    public List<OperacionCambioMoneda> listaOperaciones(){
        return this.operacionservice.listaOperaciones();
    }


}
