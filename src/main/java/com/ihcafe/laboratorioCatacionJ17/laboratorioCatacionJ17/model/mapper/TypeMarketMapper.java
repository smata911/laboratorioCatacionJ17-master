package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeMarketDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeMarket;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMarketMapper {
    TypeMarket dtoToTypeMarket(TypeMarketDto dto);

    TypeMarketDto typeMarketToDto(TypeMarket producer);

    List<TypeMarket> dtoToTypeMarket(List<TypeMarketDto> dtos);

    List<TypeMarketDto> typeMarketToDto(List<TypeMarket> typeMarket);
}
