package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeMarketDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeMarketService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.VarietiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/TypeMarket")
@RequiredArgsConstructor
public class TypeMarketController {

    private  final TypeMarketService typeMarketService;


    @GetMapping(value = "/lista")
    @PreAuthorize("hasAuthority('READ_TYPEMARKET')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<TypeMarketDto>> findAll() {
        List<TypeMarketDto> retrievedTypeMarket = typeMarketService.getAllTypeMarket();

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedTypeMarket, HttpStatus.OK);
    }


}
