package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;


import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.TypeMarketDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.TypeMarket;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.TypeMarketMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.VarietiesMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.TypeMarketRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.TypeMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeMarketServiceImp implements TypeMarketService {
    private  final TypeMarketRepository typeMarketRepository;
    private  final TypeMarketMapper typeMarketMapper;
    @Override
    public List<TypeMarketDto> getAllTypeMarket() {
        List<TypeMarket> typeMarkets=typeMarketRepository.findAll();
        return typeMarketMapper.typeMarketToDto(typeMarkets);
    }
}
