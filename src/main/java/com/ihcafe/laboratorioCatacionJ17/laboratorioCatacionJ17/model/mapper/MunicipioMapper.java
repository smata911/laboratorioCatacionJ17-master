package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.EstudiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.MunicipioDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Estudies;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Municipio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MunicipioMapper {


    Municipio dtoToMunicipio(MunicipioDto dto);

    MunicipioDto MunicipioToDto(Municipio producer);

    List<Estudies> dtoToMunicipios(List<MunicipioDto> dtos);

    List<MunicipioDto> MunicipioToDto(List<Municipio> varieties);
}
