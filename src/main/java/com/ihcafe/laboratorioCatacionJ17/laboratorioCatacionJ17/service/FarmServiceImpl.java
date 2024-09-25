package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.FarmMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.ProducerMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.FarmRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService{

    private final FarmRepository farmRepository;
    private final ProducerRepository producerRepository;
    private final FarmMapper farmMapper;
    private final Messages messages;
    @Override
    public FarmDto saveFarm(String producerIdp, FarmDto farmDto) {
        String farmName = farmDto.getFarmName();
        Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerIdp);
        Optional<Farm> existingfarmAndProducer =farmRepository.findByFarmNameAndProducerId(farmName, existingProducer.get());

        //Optional<Farm> existingFarm=farmRepository.findByFarmId(farmDto.)
        Farm farm = null;
        if (existingProducer.isPresent()) {

            if (existingfarmAndProducer.isEmpty()){
                Producer producer = existingProducer.get();
                farm=Farm.buildFromDto(this.farmMapper.dtoToFarm(farmDto),producer);
            }else if (existingfarmAndProducer.isPresent()){
                System.out.println("ya existe");
            }


        } else if(existingProducer.isEmpty()) {
            System.out.println("no existe producer");
        }else {
            System.out.println("esta nul");
        }
        this.farmRepository.save(farm);
        return farmMapper.farmToDto(farm);
    }

    @Override
    public FarmDto findFarmtById(String farmId) throws ProducerNotFoundException {
        return null;
    }
}
