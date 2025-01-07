package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeSampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeSample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeSampleMapper {

    TypeSample dtoToTypeSample(TypeSampleDto dto);

    TypeSampleDto typeSampleToDto(TypeSample producer);

    List<TypeSample> dtoToTypeSample(List<TypeSampleDto> dtos);

    List<TypeSampleDto> typeSampleToDto(List<TypeSample> typeSample);
}
