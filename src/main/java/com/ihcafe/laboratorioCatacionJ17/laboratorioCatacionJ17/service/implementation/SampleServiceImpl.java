package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Farm;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Varieties;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.SampleMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.FarmRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SampleRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.VarietiesRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import jakarta.persistence.EntityNotFoundException;
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
    private final FarmRepository farmRepository;
    private  final VarietiesRepository varietiesRepository;

    private final SampleMapper sampleMapper;

    private final Messages messages;

    @Override
    public SampleDto saveSample(final String farmIdp, final SampleDto sampleDto) {
        Sample sample = null;
        Optional<Farm> existingFarm = farmRepository.findByFarmId(farmIdp);
        String farmId=null;
        List<String> varietyIds = sampleDto.getSampleVarieties()
                .stream()
                .map(Varieties::getVarietiesId)
                .collect(Collectors.toList());
        List<Varieties> existingVarieties = varietiesRepository.findAllByVarietiesIdIn(varietyIds);
        boolean allExist=existingFarm.isPresent() && existingVarieties.size()== varietyIds.size();

        if (allExist) {
            Farm farm = existingFarm.get();
            List<Varieties> varietiesList =new ArrayList<>();
            for (Varieties var : sampleDto.getSampleVarieties()){
               varietiesList.add(var);
            }
            sample = Sample.buildFromDto(this.sampleMapper.dtoToSample(sampleDto), farm,varietiesList);

        } else {
            System.out.println("Recuerda modificar los mensajes ");
           // return sampleMapper.sampleToDto(sample);
        }
        this.sampleRepository.save(sample);
        return sampleMapper.sampleToDto(sample);
    }


    @Override
    public SampleDto updateSample(final String sampleId, final SampleDto sampleDto) {
        String farmid = sampleDto.getFarmId().getFarmId();

        // Buscar la muestra existente por su sampleId
        Optional<Sample> existingSampleOpt = sampleRepository.findBySampleId(sampleId);

        Optional<Farm> existingFarm = farmRepository.findByFarmId(farmid); // Verificar que farmId exista

        // Obtener los IDs de las variedades desde el DTO
        List<String> varietyIds = sampleDto.getSampleVarieties()
                .stream()
                .map(Varieties::getVarietiesId)
                .collect(Collectors.toList());

        // Buscar las variedades existentes por sus IDs
        List<Varieties> existingVarieties = varietiesRepository.findAllByVarietiesIdIn(varietyIds);

        // Validar si existen tanto la muestra, la granja y las variedades
        boolean allExist = existingSampleOpt.isPresent() && existingFarm.isPresent() && existingVarieties.size() == varietyIds.size();


        Sample existingSample = existingSampleOpt.get();

        if (allExist) {
            // Actualizar la entidad existente
            Farm farm = existingFarm.get();

            // Actualizar los campos de la muestra con los valores del DTO
            existingSample.setFarm(farm);
            existingSample.setSampleWeight(sampleDto.getSampleWeight());
            existingSample.setSamplePercentageHumidity(sampleDto.getSamplePercentageHumidity());
            existingSample.setTypeSample(sampleDto.getTypeSample());
            existingSample.setTypeProcess(sampleDto.getTypeProcess());
            existingSample.setTypeMarket(sampleDto.getTypeMarket());
            existingSample.setSampleDate(sampleDto.getSampleDate());
            existingSample.setSampleStatus(sampleDto.getSampleStatus());

            // Actualizar la relación ManyToMany con variedades
            existingSample.setVarietiesSample(existingVarieties);

        } else {
            // Manejo de errores en caso de que algo no exista
            throw new EntityNotFoundException("La muestra, la farm o las variedades no existen.");
        }

        // Guardar los cambios en la base de datos
        this.sampleRepository.save(existingSample);
        System.out.println(existingSample.getSampleId());

        // Retornar el DTO actualizado
        return sampleMapper.sampleToDto(existingSample);
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







