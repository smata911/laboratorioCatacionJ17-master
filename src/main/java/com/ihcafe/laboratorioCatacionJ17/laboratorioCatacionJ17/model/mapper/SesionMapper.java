package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SesionDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sesion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SesionMapper {

    SesionDto sesionToDto(Sesion sesion);

    Sesion dtoToSesion(SesionDto dto);

    List<SesionDto> sesionToDto(List<Sesion> samples);
    List<Sesion> dtosToSesion(List<SesionDto> dtos);

}
