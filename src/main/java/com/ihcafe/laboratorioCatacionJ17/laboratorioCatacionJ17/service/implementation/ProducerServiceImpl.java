package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.ProducerMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ProducerService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;


    private final ProducerMapper producerMapper;

    /*private final SubjectMapper subjectMapper;

    private final SubjectService subjectService;*/

//    private final SortingPagingUtils sortingPagingUtils;

    private final Messages messages;




    @Override
    public ProducerDto saveProducer(final ProducerDto producerDto) {
        String producerIdentidad = producerDto.getProducerIdentidad();
        Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerIdentidad);
        Producer producer = null;

        if (existingProducer.isPresent()) {
            // El productor ya existe, actualiza los atributos
            producer = existingProducer.get();
            producer.setProducerFirstName(producerDto.getProducerFirstName());
            producer.setProducerLastName(producerDto.getProducerLastName());
            producer.setProducerGender(producerDto.getProducerGender());

            System.out.println("Ya existe, se actualizó");
        } else if(existingProducer.isEmpty()) {
            // El productor no existe, guardalo y genera el uuid
            producer = Producer.buildFromDto(this.producerMapper.dtoToProducer(producerDto));
            System.out.println("No existe, se guardó");
        }else {
            System.out.println("esta nul");
        }
        // Guarda el productor (ya sea existente o nuevo)
        this.producerRepository.save(producer);
        return producerMapper.producerToDto(producer);
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
