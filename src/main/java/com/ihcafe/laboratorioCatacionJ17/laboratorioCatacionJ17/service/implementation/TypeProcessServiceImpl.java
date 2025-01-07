package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeMarketDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeProcessDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeProcess;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.TypeProcessMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.VarietiesMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.TypeProcessRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeMarketService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeProcessServiceImpl implements TypeProcessService {
    private  final TypeProcessRepository typeProcessRepository;
    private  final TypeProcessMapper typeProcessMapper;


    @Override
    public List<TypeProcessDto> getAllTypeProcess() {
        List<TypeProcess> varieties = typeProcessRepository.findAll();
        return typeProcessMapper.typeProcessToDto(varieties);
    }
}
