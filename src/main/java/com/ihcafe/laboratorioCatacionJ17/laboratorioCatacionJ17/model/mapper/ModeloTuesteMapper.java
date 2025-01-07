package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTuesteDto;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModelosTueste;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ModeloTuesteMapper {


    ModelosTueste dtoToModeloTueste(ModeloTuesteDto dto);

    ModeloTuesteDto modeloTuesteToDto(ModelosTueste modelo);

    List<ModelosTueste> dtosToModelosTueste(List<ModeloTuesteDto> modelDtos);
    List<ModeloTuesteDto> modelosToDtos(List<ModelosTueste> modelos);
    // default ModeloTuesteDto modelosToModeloTuesteDto(List<ModelosTueste> models) {
    //     ModeloTuesteDto dto = ModeloTuesteDto.builder().(new ArrayList<>(models)).build();
    //     return dto;
    // }
}
