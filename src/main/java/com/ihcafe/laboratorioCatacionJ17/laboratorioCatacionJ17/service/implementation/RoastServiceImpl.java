package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.RoastDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sample;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Temperature;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.RoastMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.SampleMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.TemperatureMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.RoastRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SampleRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.TemperatureRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.RoastService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoastServiceImpl implements RoastService{

    private final RoastRepository roastRepository;
    private  final SampleRepository sampleRepository;
    private final RoastMapper roastMapper;
    private final SampleMapper sampleMapper;
    private final TemperatureRepository temperatureRepository;
    private final TemperatureMapper temperatureMapper;

    private final Messages messages;
    @Override
    public RoastDto saveRoast(final String sampleIdp,final RoastDto roastDto) {
        Roast roast=null;
        Optional<Sample> existingSample= sampleRepository.findBySampleId(sampleIdp);
        if (existingSample.isPresent()) {
            System.out.println(existingSample.get().getSampleId());
            Sample sample = existingSample.get();
            roast = Roast.buildFromDto(this.roastMapper.dtoToRoast(roastDto),sample);
            // Iterar sobre las Temperaturas en RoastDto y mapearlas a entidades Temperature
            List<Temperature> listTemperatures = new ArrayList<>();
            for (Temperature temperature : roastDto.getRoastTemperature()) {
                // Temperature temperature = temperatureMapper.dtoToTemperature(temperatureDto);
                temperature.setRoast(roast);
                Temperature temperatureuid =Temperature.buildFromDto(temperature);
                listTemperatures.add(temperatureuid);
            }//todo falta validar que los minutos sean diferentes mediante el roast_id
            // Asignar las Temperaturas mapeadas a Roast
            roast.setRoastTemperature(listTemperatures);
            //System.out.println(roastDto.getSampleId());
        }else if (existingSample.isEmpty()){
            System.out.println("la muestra no se encuentra");
        }
        this.roastRepository.save(roast);
        return roastMapper.roastToDto(roast);

    }

    @Override
    public RoastDto updateRoast(final String roastId, final RoastDto roastDto) {//todo mejorar los nombres de las variables y quitar

        List<String> getTemperatureDto = Temperature.DtototemperatureIds(roastDto.getRoastTemperature());
        List<Temperature> temperatureListBaseDatos = temperatureRepository.findAllByTemperatureIdIn(getTemperatureDto);
        // Verificar si el Roast asociado a ese Sample ya existe
        Optional<Roast> existingRoastOpt = roastRepository.findByRoastId(roastId);
        Roast existingRoast = null;
        if (existingRoastOpt.isPresent() ) {
            existingRoast = existingRoastOpt.get();
            // Actualizar los campos del Roast existente con los datos del RoastDto
            existingRoast.setRoastTemperature(roastDto.getRoastTemperature());
        }else{
            System.out.println("Roast not found with sampleId");
        }

        // Manejar las Temperaturas asociadas al Roast
        List<Temperature> updatedTemperatures = new ArrayList<>();
        for (Temperature temperature : roastDto.getRoastTemperature()) {
            // Actualizar cada temperatura en base al DTO
            temperature.setRoast(existingRoast); // Asignar el Roast actual a cada temperatura
            //Temperature updatedTemperature = Temperature.buildFromDto(temperature);
            updatedTemperatures.add(temperature);
        }

        boolean existenTemperatures=temperatureListBaseDatos.size()==getTemperatureDto.size();
        if (existenTemperatures){
            System.out.println("existe todoo");
            // Actualizar las temperaturas en el Roast
            existingRoast.setRoastTemperature(updatedTemperatures);
            // Guardar el Roast actualizado (junto con las temperaturas)
            Roast updatedRoast = roastRepository.save(existingRoast);
        }else{
            System.out.println("una temperatura no existe en el servidodr");
        }
        // Retornar el DTO del Roast actualizado
        return roastMapper.roastToDto(existingRoast);
    }


    @Override
    public ProducerDto findRoastById(String roastId) throws ProducerNotFoundException {
        return null;
    }

    @Override
    public ProducerDto findRoastByName(String roastFirstName) throws ProducerNotFoundException {
        return null;
    }

    @Override
    public RoastDto findRoustByIdentidad(String roustIdentidad) throws ProducerNotFoundException {
        return null;
    }

    @Override
    public void deleteRoustById(String roustId) {

    }

    @Override
    public Page<RoastDto> findPaginatedSortedRoust(String RoustFirstName, int page, int size, String[] sort) {
        return null;
    }

    public Optional<Sample> findBySampleId(final String sampleId) {
        return this.sampleRepository.findBySampleId(sampleId);
    }



}
