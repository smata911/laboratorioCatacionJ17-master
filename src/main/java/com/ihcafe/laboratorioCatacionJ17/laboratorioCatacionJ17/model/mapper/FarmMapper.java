package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    Farm dtoToFarm(FarmDto dto);
    FarmDto farmToDto(Farm sample);

}
