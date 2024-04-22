package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TemperatureDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Temperature;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TemperatureMapper {
    Temperature dtoToTemperature(TemperatureDto dto);

    TemperatureDto temperatureToDto(Temperature temperature);

    List<Temperature> dtoToTemperature(List<TemperatureDto> dtos);


    List<TemperatureDto> temperatureToDto(List<Temperature> temperature);
}
