package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleMapper {

    SampleDto sampleToDto(Sample sample);

    //@Mapping(target = "farm", ignore = true) // Se buscará después por el ID
    Sample dtoToSample(SampleDto dto);

    List<SampleDto> sampleToDto(List<Sample> samples);
    List<Sample> dtosToSample(List<SampleDto> dtos);
}
