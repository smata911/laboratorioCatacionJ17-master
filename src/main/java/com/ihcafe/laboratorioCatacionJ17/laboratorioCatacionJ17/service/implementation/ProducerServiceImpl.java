package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.ProducerMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.FarmRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ProducerService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.MessageKey;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;
    private final Messages messages;
    private final FarmRepository farmRepository;

    @Override
    public ProducerDto saveProducer(final ProducerDto producerDto) {
        String producerIdentidad = producerDto.getProducerIdentidad();
        String farmName = producerDto.getProducerFarm().get(0).getFarmName();
        Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerIdentidad);
       // Optional<Farm> existingfarmAndProducer =farmRepository.findByFarmNameAndProducer_ProducerId(farmName, existingProducer.get().getProducerId());
        Producer producer = null;
        Farm farm=producerDto.getProducerFarm().get(0);


        if (existingProducer.isPresent()) {//mejor uso put

            // El productor no existe, guardalo y genera el uuid
        } else if(existingProducer.isEmpty()) {
            producer = Producer.buildFromDto(this.producerMapper.dtoToProducer(producerDto));
            System.out.println(this.producerMapper.dtoToProducer(producerDto).getProducerFirstName());
            System.out.println("No existe, se guardó"+messages.getMessage(MessageKey.ENTITY_SAVE.getKey()));
        }else {
            System.out.println("esta nul");
        }
        // Guarda el productor (ya sea existente o nuevo)

        this.producerRepository.save(producer);
        return producerMapper.producerToDto(producer);
    }



    @Override
    public ProducerDto updateProducer(final String producerIdentidad, final ProducerDto producerDto) {
        //Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerIdentidad);
        Optional<Producer> existingProducer = producerRepository.findById(producerIdentidad);
        Producer producer = null;
        // Verificar si el productor existe para actualizar
        if (existingProducer.isPresent()) {

            producer = existingProducer.get();
            producer.setProducerFirstName(producerDto.getProducerFirstName());
            producer.setProducerLastName(producerDto.getProducerLastName());
            producer.setProducerGender(producerDto.getProducerGender());

            //validar los repetidos por nombre
            producer.setProducerFarm(producerDto.getProducerFarm());


            this.producerRepository.save(producer);
            System.out.println(messages.getMessage(MessageKey.ENTITY_UPDATE.getKey()));
            System.out.println(producerDto.getProducerFarm());

        } else {
            // El productor no existe, lanzar una excepción o manejar el caso
            System.out.println(messages.getMessage(MessageKey.ENTITY_NOT_FOUND.getKey()));

        }

        return producerMapper.producerToDto(producer);
    }

    @Override
    public Page<ProducerDto> getProducerIdentidadContainingIgnoreCase(String producerIdentidad, Pageable pageable) {
        if (producerIdentidad==null){
            producerIdentidad="1";

        }
        // Obtener todos los productores de la base de datos
        Page<Producer> producersPage = producerRepository.findByProducerIdentidadContainingIgnoreCaseOrderByProducerFechaRegistroDesc(producerIdentidad,pageable);
        List<ProducerDto> producerDtoList = producerMapper.producerToDto(producersPage.getContent());
        // Mapear la lista de productores a una lista de ProducerDto
//        return producers.stream()
//                .map(producerMapper::producerToDto)
//                .collect(Collectors.toList());


//        for (Producer producer : producers) {
//            System.out.println("Producer Identidad: " + producer.getProducerIdentidad());
//
//            if (producer.getProducerFarm() != null && !producer.getProducerFarm().isEmpty()) {
//                for (Farm farm : producer.getProducerFarm()) {
//                    System.out.println(" - Farm ID: " + farm.getFarmId());
//                    System.out.println(" - Farm Name: " + farm.getFarmName());
//                }
//            } else {
//                System.out.println(" - No farms associated.");
//            }
//        }
       // System.out.println(producers.ge);

        return new PageImpl<>(producerDtoList,pageable,producersPage.getTotalElements());
    }


    @Override
    public ProducerDto findProducertById(final String producerId){
        Producer producer=producerRepository.findById(producerId).orElseThrow(()-> ProducerNotFoundException.buildProducerNotFoundExceptionForId(producerId));

        return producerMapper.producerToDto(isActiveProducer(producer,"producerId",producerId));
    }

    @Override
    public ProducerDto findProducerByName(final String producerFirstName) {
        Producer producer=this.producerRepository.findByProducerFirstName(producerFirstName)
                .orElseThrow(()->ProducerNotFoundException
                        .buildProducerNotFoundExceptionForField("producerFirstName",producerFirstName));
        return producerMapper.producerToDto(isActiveProducer(producer,"producerFirstName",producerFirstName));
    }

    @Override
    public ProducerDto findProducerByIdentidad(String producerIdentidad) {
        Producer producer=this.producerRepository.findByProducerIdentidad(producerIdentidad)
                .orElseThrow(()->ProducerNotFoundException
                        .buildProducerNotFoundExceptionForField("producerIdentidad",producerIdentidad));
        return producerMapper.producerToDto(isActiveProducer(producer,"producerIdentidad",producerIdentidad));

    }

    @Override
    public void deleteProducerById(String producerId) {

    }

    @Override
    public Page<ProducerDto> findPaginatedSortedStudents(String producerName, int page, int size, String[] sort) {
        return null;
    }


    private Producer isActiveProducer(Producer producer, String queryField, String queryFieldValue){
        if(producer.getProducerStatus().getStatusCode() == 0){
            return producer;
        }
        throw ProducerNotFoundException
                .buildProducerNotFoundExceptionForField(queryField, queryFieldValue);
    }
}
