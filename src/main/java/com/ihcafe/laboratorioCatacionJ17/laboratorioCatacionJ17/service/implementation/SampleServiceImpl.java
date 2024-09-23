package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.SampleMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SampleRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//todo falta el update
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService{
    private  final SampleRepository sampleRepository;
    private final ProducerRepository producerRepository;
    private  final VarietiesRepository varietiesRepository;

    private final SampleMapper sampleMapper;

    private final Messages messages;

    @Override
    public SampleDto saveSample(final String producerIdp, final SampleDto sampleDto) {
        Sample sample = null;
        Optional<Producer> existingProducer = producerRepository.findByProducerIdentidad(producerIdp);
        List<String> varietyIds = sampleDto.getSampleVarieties()
                .stream()
                .map(Varieties::getVarietiesId)
                .collect(Collectors.toList());
        List<Varieties> existingVarieties = varietiesRepository.findAllByVarietiesIdIn(varietyIds);
        boolean allExist=existingProducer.isPresent() && existingVarieties.size()== varietyIds.size();

        if (allExist) {
            Producer producer = existingProducer.get();
            List<Varieties> varietiesList =new ArrayList<>();
            for (Varieties var : sampleDto.getSampleVarieties()){
               varietiesList.add(var);
            }
            sample = Sample.buildFromDto(this.sampleMapper.dtoToSample(sampleDto), producer,varietiesList);


        } else {
            System.out.println("Recuerda modificar los mensajes ");
           // return sampleMapper.sampleToDto(sample);
        }
        this.sampleRepository.save(sample);
        return sampleMapper.sampleToDto(sample);
    }





    @Override
    public SampleDto findSampletById(String sampleId) throws ProducerNotFoundException {
        return null;
    }

    @Override
    public ProducerDto findProducerByName(String producerFirstName) throws ProducerNotFoundException {
        return null;
    }

    @Override
    public ProducerDto findProducerByIdentidad(String producerIdentidad) throws ProducerNotFoundException {
        return null;
    }

    @Override
    public void deleteProducerById(String producerId) {

    }

    @Override
    public Page<ProducerDto> findPaginatedSortedStudents(String producerFirstName, int page, int size, String[] sort) {
        return null;
    }



//    public Optional<Producer> findByProducerId(final String producerId) {
//        return this.producerRepository.findByProducerIdentidad(producerId);
//    }
//    public List<Varieties> verificarExistencia(List<String> ids) {
//        return this.varietiesRepository.findAllByVarietiesIdIn(ids);
//    }


}







