package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTiempoDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTuesteDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModeloTiempos;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModelosTueste;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModeloTiempoMapper {

    ModeloTiempos dtoToModeloTiempos(ModeloTiempoDto dto);

    ModeloTiempoDto ModeloTiemposToDto(ModeloTiempos modelo);

    List<ModeloTiempos> dtosToModeloTiempos(List<ModeloTiempoDto> modelDtos);
    List<ModeloTiempoDto> modelosToDtos(List<ModeloTiempos> modelos);
}
