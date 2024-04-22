package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;


@Mapper(componentModel = "spring")
public interface ProducerMapper {

    Producer dtoToProducer(ProducerDto dto);

    ProducerDto producerToDto(Producer producer);

    List<Producer> dtoToProducer(List<ProducerDto> dtos);

    List<ProducerDto> producerToDto(List<Producer> producer);


}
