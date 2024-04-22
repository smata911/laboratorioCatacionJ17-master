package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.openapi;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.pageable.PageResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PageResponseProducerDto")
public class PageResponseProducerDto extends PageResponseDto<ProducerDto> {
}
