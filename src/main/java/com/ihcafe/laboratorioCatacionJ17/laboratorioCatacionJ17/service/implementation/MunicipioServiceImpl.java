package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.MunicipioDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Estudies;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Municipio;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.MunicipioMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.MunicipioRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipioServiceImpl  implements MunicipioService {

    private  final MunicipioRepository municipioRepository;
    private  final MunicipioMapper municipioMapper;
    @Override
    public List<MunicipioDto> getAllMunicipio() {

        List<Municipio> municipios=municipioRepository.findAll();
        return municipioMapper.MunicipioToDto(municipios);
    }
}
