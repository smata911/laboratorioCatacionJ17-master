package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SesionDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;

import java.util.List;

public interface SesionService {

    SesionDto saveSesion(SesionDto sesionDto);
    List<SesionDto> getAllSesion();
}
