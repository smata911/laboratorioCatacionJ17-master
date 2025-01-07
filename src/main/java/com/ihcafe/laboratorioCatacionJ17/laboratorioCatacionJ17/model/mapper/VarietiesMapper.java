package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VarietiesMapper {
    Varieties dtoToVarieties(VarietiesDto dto);

    VarietiesDto varietiesToDto(Varieties producer);

    List<Varieties> dtoToVarieties(List<VarietiesDto> dtos);

    List<VarietiesDto> varietiesToDto(List<Varieties> varieties);
}
