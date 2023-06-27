package com.amva.apiprueba.mapper;
import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.persistence.Entity.TIpoCambio;
import com.amva.apiprueba.service.dto.OperacionCambioINDto;
import com.amva.apiprueba.service.dto.TIpoCambioINDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TIpoCambioToTIpoCambioDTO implements  IMapper<TIpoCambioINDto, TIpoCambio> {
    @Override
    public TIpoCambio map(TIpoCambioINDto in){
        TIpoCambio tipoCambio= new TIpoCambio();
        tipoCambio.setFechaOperacion(LocalDateTime.now());
        tipoCambio.setValor(in.getValor());
        return tipoCambio;
    }
}
