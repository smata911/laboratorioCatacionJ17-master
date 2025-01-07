package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleMapper {

    SampleDto sampleToDto(Sample sample);

    Sample dtoToSample(SampleDto dto);

    List<SampleDto> sampleToDto(List<Sample> samples);
    List<Sample> dtosToSample(List<SampleDto> dtos);

    // Asegúrate de que se pueda mapear entre Varieties y VarietiesDto
    //VarietiesDto varietiesToDto(Varieties varieties);
//    Varieties dtoToVarieties(VarietiesDto varietiesDto);
}