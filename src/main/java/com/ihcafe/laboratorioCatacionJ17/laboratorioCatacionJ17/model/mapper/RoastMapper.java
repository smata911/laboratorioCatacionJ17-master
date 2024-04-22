package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoastMapper {

    Roast dtoToRoast(RoastDto dto);

   RoastDto roastToDto(Roast roast);

    List<Roast> dtotoRoast(List<RoastDto> dtos);

     List<RoastDto> roastToDto(List<Roast> roast);

    Sample roastS(String value);

    String roasS(Sample sample);


}
