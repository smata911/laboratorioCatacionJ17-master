package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.EstudiesDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Estudies;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.EstudiesMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.VarietiesMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.EstudiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.EstudiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudiesServiceImpl implements EstudiesService {
    private  final EstudiesRepository estudiesRepository;
    private  final EstudiesMapper estudiesMapper;

    @Override
    public List<EstudiesDto> getAllEstudies() {
        List<Estudies> estudies=estudiesRepository.findAll();
        return estudiesMapper.EstudiesToDto(estudies);
    }
}
