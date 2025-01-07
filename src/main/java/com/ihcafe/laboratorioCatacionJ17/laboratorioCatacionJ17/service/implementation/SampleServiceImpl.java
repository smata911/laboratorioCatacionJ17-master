package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.*;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.SampleMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.*;
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
    private final EstudiesRepository estudiesRepository;

    private final SampleMapper sampleMapper;

    private final Messages messages;

    @Override
    public SampleDto saveSample(final String farmIdp, final SampleDto sampleDto) {
        Sample sample = null;
        Optional<Farm> existingFarm = farmRepository.findByFarmId(farmIdp);
        String farmId=null;
        List<String> varietyIds = sampleDto.getVarietiesSample()
                .stream()
                .map(Varieties::getVarietiesId)
                .collect(Collectors.toList());
        List<Varieties> existingVarieties = varietiesRepository.findAllByVarietiesIdIn(varietyIds);


        List<String> estudiesIds = sampleDto.getSampleEstudies()
                .stream()
                .map(Estudies::getEstudiesId)
                .collect(Collectors.toList());
        List<Estudies> existingEstudies = estudiesRepository.findAllByEstudiesIdIn(estudiesIds);
        boolean allExist=existingFarm.isPresent() &&
                existingVarieties.size()== varietyIds.size() &&
                existingEstudies.size()==estudiesIds.size();

        if (allExist) {
            Farm farm = existingFarm.get();
            List<Varieties> varietiesList =new ArrayList<>();
            List<Estudies> estudiesList=new ArrayList<>();

            for (Varieties var : sampleDto.getVarietiesSample()){//todo con mapper
               varietiesList.add(var);
            }

            for (Estudies valor :sampleDto.getSampleEstudies()){
                estudiesList.add(valor);
            }
            sample = Sample.buildFromDto(this.sampleMapper.dtoToSample(sampleDto), farm,varietiesList,estudiesList);

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
        List<String> varietyIds = sampleDto.getVarietiesSample()
                .stream()
                .map(Varieties::getVarietiesId)
                .collect(Collectors.toList());

        // Buscar las variedades existentes por sus IDs
        List<Varieties> existingVarieties = varietiesRepository.findAllByVarietiesIdIn(varietyIds);


        // Obtener los IDs de las estudies desde el DTO
        List<String> estudiesIds = sampleDto.getSampleEstudies()
                .stream()
                .map(Estudies::getEstudiesId)
                .collect(Collectors.toList());

        // Buscar las variedades existentes por sus IDs
        List<Estudies> existingEstudies = estudiesRepository.findAllByEstudiesIdIn(estudiesIds);

        // Validar si existen tanto la muestra, la granja y las variedades
        boolean allExist = existingSampleOpt.isPresent() &&
                existingFarm.isPresent() &&
                existingVarieties.size() == varietyIds.size() &&
                existingEstudies.size()==estudiesIds.size();


        Sample existingSample = existingSampleOpt.get();

        if (allExist) {
            // Actualizar la entidad existente
            Farm farm = existingFarm.get();

            // Actualizar los campos de la muestra con los valores del DTO
            existingSample.setFarm(farm);
            existingSample.setSampleNumeroMuestra(sampleDto.getSampleNumeroMuestra());
            existingSample.setSampleWeight(sampleDto.getSampleWeight());
            existingSample.setSamplePercentageHumidity(sampleDto.getSamplePercentageHumidity());
            existingSample.setTypeSample(sampleDto.getTypeSample());
            existingSample.setTypeProcess(sampleDto.getTypeProcess());
            existingSample.setTypeMarket(sampleDto.getTypeMarket());
            existingSample.setSampleDate(sampleDto.getSampleDate());
            existingSample.setSampleStatus(sampleDto.getSampleStatus());

            // Actualizar la relación ManyToMany con variedades
            existingSample.setVarietiesSample(existingVarieties);
            existingSample.setEstudiesSample(existingEstudies);

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
    public List<SampleDto> getAllSample(String statu) {
        List<Sample> sampless = sampleRepository.findAllExceptFinalizado( statu);
        return sampleMapper.sampleToDto(sampless);
    }

    @Override
    public List<SampleDto> getFarmId(String farmId) {
        List<Sample> samples=sampleRepository.findByFarm_FarmId(farmId);

        return sampleMapper.sampleToDto(samples);
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







