package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeProcessDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeSampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeProcess;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeSample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.TypeProcessMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.TypeSampleMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.VarietiesMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.TypeProcessRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.TypeSampleRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeProcessService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeSampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeSampleServiceImpl implements TypeSampleService {
    private  final TypeSampleRepository typeSampleRepository;
    private  final TypeSampleMapper typeSampleMapper;

    @Override
    public List<TypeSampleDto> getAllTypeSample() {
        List<TypeSample> typeSample = typeSampleRepository.findAll();
        return typeSampleMapper.typeSampleToDto(typeSample);
    }
}
