package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.status;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ModelStatus {

    ACTIVE(0),
    INACTIVE(1);

    private final int statusCode;

}
