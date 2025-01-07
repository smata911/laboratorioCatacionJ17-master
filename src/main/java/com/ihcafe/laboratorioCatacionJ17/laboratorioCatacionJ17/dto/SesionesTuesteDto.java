package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SesionesTuesteDto {


        private String roast_id;

}
