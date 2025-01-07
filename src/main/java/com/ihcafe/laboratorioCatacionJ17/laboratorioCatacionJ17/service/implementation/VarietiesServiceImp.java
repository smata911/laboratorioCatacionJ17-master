package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.VarietiesMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.VarietiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VarietiesServiceImp implements VarietiesService {
    private  final VarietiesRepository varietiesRepository;
    private  final VarietiesMapper varietiesMapper;
    @Override
    public List<VarietiesDto> getAllVarieties() {
        List<Varieties> varieties = varietiesRepository.findAll();
        return varietiesMapper.varietiesToDto(varieties);
    }
}
