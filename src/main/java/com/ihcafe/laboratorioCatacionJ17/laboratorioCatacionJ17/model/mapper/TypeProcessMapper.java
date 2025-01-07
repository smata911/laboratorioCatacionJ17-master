package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeProcessDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeProcess;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeProcessMapper {
    TypeProcess dtoToTypeProcess(TypeProcessDto dto);

    TypeProcessDto typeProcessToDto(TypeProcess typeProcess);

    List<TypeProcess> dtoToTypeProcess(List<TypeProcessDto> dtos);

    List<TypeProcessDto> typeProcessToDto(List<TypeProcess> tpeProcess);
}
