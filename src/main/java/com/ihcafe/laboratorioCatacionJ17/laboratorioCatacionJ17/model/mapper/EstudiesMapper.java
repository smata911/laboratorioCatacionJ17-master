package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;



import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.EstudiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Estudies;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EstudiesMapper {

    Estudies dtoToEstudies(EstudiesDto dto);

    EstudiesDto EstudiesToDto(Estudies producer);

    List<Estudies> dtoToEstudies(List<EstudiesDto> dtos);

    List<EstudiesDto> EstudiesToDto(List<Estudies> varieties);
}
