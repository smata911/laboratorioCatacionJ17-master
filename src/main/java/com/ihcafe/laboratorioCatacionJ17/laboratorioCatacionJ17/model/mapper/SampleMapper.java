package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleMapper {
    Sample dtoToSample(SampleDto dto);

   //SampleDto sampleToDto(Sample sample);

    List<Sample> dtotoSample(List<SampleDto> dtos);

    List<Sample> sampleToDto(List<Sample> samples);


}
