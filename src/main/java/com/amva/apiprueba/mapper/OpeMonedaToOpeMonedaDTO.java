package com.amva.apiprueba.mapper;

import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.service.dto.OperacionCambioINDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OpeMonedaToOpeMonedaDTO implements  IMapper<OperacionCambioINDto, OperacionCambioMoneda>{


    @Override
    public OperacionCambioMoneda map(OperacionCambioINDto in){
        OperacionCambioMoneda operacionCambioMoneda= new OperacionCambioMoneda();
        operacionCambioMoneda.setMonedaOrigen(in.getMonedaOrigen());
        operacionCambioMoneda.setMonedaDestino(in.getMonedaDestino());
        operacionCambioMoneda.setMonto(in.getMonto());
        operacionCambioMoneda.setFechaOperacion(LocalDateTime.now());
        return operacionCambioMoneda;
    }
}
