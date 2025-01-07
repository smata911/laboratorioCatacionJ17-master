package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.FarmDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.FarmMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.ProducerMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.FarmRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.FarmService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final ProducerRepository producerRepository;
    private final FarmMapper farmMapper;
    private final Messages messages;
    @Override
    public FarmDto saveFarm(String producerIdp, FarmDto farmDto) {
        String farmName = farmDto.getFarmName();
        //Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerIdp);
        Optional<Producer> existingProducer = producerRepository.findById(producerIdp);
        Optional<Farm> existingfarmAndProducer =farmRepository.findByFarmNameAndProducer_ProducerId(farmName, existingProducer.get().getProducerId());

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
    public List<FarmDto> getAllFarm() {
        List<Farm> farms=farmRepository.findAll();
        return farmMapper.farmToDto(farms);
    }

    @Override
    public List<FarmDto> getAllFarmProducer(String producerId) {

        List<Farm> farms=farmRepository.findFarmsByProducer_ProducerId(producerId);
        return farmMapper.farmToDto(farms);
    }

    @Override
    public FarmDto updateFarm(String producerId, FarmDto farmDto) {
        // Obtener el nombre de la finca desde el DTO
        String farmName = farmDto.getFarmName();
        // Buscar el productor en la base de datos
      //  Optional<Producer> existingProducer = producerRepository.findById(producerId);
        // Verificar si el productor existe
        //if (existingProducer.isEmpty()) {
          //  System.out.println("El productor no existe.");
            //return null;
        //}

        // Buscar la finca específica del productor
       // Optional<Farm> existingFarm = farmRepository.findByFarmNameAndProducer_ProducerId(farmName, producerId);
       Optional<Farm> existingFarm = farmRepository.findById(producerId);

        if (existingFarm.isPresent()) {
            // Obtener la finca existente y actualizar los detalles con el DTO
            Farm farmToUpdate = existingFarm.get();
            farmToUpdate.setFarmName(farmDto.getFarmName());
            farmToUpdate.setFarmObservacion(farmDto.getFarmObservacion());
            farmToUpdate.setFarmClave(farmDto.getFarmClave());
            farmToUpdate.setFarmAltitud(farmDto.getFarmAltitud());
            farmToUpdate.setMunicipio(farmDto.getMunicipio());
            farmToUpdate.setFarmSitio(farmDto.getFarmSitio());

            // Guardar la finca actualizada en el repositorio
            farmRepository.save(farmToUpdate);
            return farmMapper.farmToDto(farmToUpdate);
        } else {
            System.out.println("La finca especificada no existe para el productor.");
            return null;
        }
    }


    @Override
    public FarmDto findFarmtById(String farmId) throws ProducerNotFoundException {
        return null;
    }
}
