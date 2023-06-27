package com.amva.apiprueba.service;

import com.amva.apiprueba.mapper.OpeMonedaToOpeMonedaDTO;
import com.amva.apiprueba.mapper.TIpoCambioToTIpoCambioDTO;
import com.amva.apiprueba.persistence.Entity.OperacionCambioMoneda;
import com.amva.apiprueba.persistence.Entity.TIpoCambio;
import com.amva.apiprueba.persistence.repository.OperacionCambioMonedaRepository;

import com.amva.apiprueba.persistence.repository.TipoCambioRepository;
import com.amva.apiprueba.service.dto.OperacionCambioINDto;
import com.amva.apiprueba.service.dto.TIpoCambioINDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionCambioMonedaService {

    private final OperacionCambioMonedaRepository repository;
    private final TipoCambioRepository repositoryTipoCambio;
    private final OpeMonedaToOpeMonedaDTO mapper;

    private final TIpoCambioToTIpoCambioDTO mapperTipoCambio;
    private double tipoCambioObtenido;


    public OperacionCambioMonedaService(OperacionCambioMonedaRepository repository, TipoCambioRepository repositoryTipoCambio, OpeMonedaToOpeMonedaDTO mapper, TIpoCambioToTIpoCambioDTO mapperTipoCambio) {
        this.repository = repository;
        this.repositoryTipoCambio = repositoryTipoCambio;
        this.mapper = mapper;
        this.mapperTipoCambio = mapperTipoCambio;
    }



    public OperacionCambioMoneda createOperacionCambioMoneda(OperacionCambioINDto operacionCambioINDto) {

        tipoCambioObtenido=3;
        //obtiene el ultimo cambio vigente
        tipoCambioObtenido=tipoCambioVigente().getValor();

        OperacionCambioMoneda operacionCambioMoneda = mapper.map(operacionCambioINDto);
        operacionCambioMoneda.setTipoCambio(tipoCambioObtenido);
        operacionCambioMoneda.setMontoConTIpoCambio(operacionCambioMoneda.getMonto()*tipoCambioObtenido);
        return this.repository.save(operacionCambioMoneda);
    }

    public TIpoCambio createActualizaTipoCambio(TIpoCambioINDto tipoCambioINDto) {
        TIpoCambio tipoCambio= mapperTipoCambio.map(tipoCambioINDto);
        return this.repositoryTipoCambio.save(tipoCambio);
    }

    public List<OperacionCambioMoneda> listaOperaciones() {
        return this.repository.findAll();
    }

    public List<TIpoCambio> listaTipoCambioHistorico() {
        return this.repositoryTipoCambio.findAll();
    }

    public TIpoCambio tipoCambioVigente() {

        return this.repositoryTipoCambio.findAll().get(this.repositoryTipoCambio.findAll().size()-1);
    }
}
