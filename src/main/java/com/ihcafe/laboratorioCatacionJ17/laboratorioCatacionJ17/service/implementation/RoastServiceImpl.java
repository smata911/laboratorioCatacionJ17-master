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
import org.apache.tomcat.util.bcel.Const;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoastServiceImpl implements RoastService{
    private final String statusSample ="TuesteFinallizado";
    private final RoastRepository roastRepository;
    private  final SampleRepository sampleRepository;
    private final RoastMapper roastMapper;
    private final SampleMapper sampleMapper;
    private final TemperatureRepository temperatureRepository;
    private final TemperatureMapper temperatureMapper;
    private double newCountSample;
    private String ROAST_STATUS="sinSesion";
    private final Messages messages;
    @Override
    public RoastDto saveRoast(final String sampleIdp, final RoastDto roastDto) {


        Roast roast=null;
        roastDto.setRoastStatus(ROAST_STATUS);
        Optional<Sample> existingSample = sampleRepository.findBySampleId(sampleIdp);
        System.out.println(sampleIdp);
        if (existingSample.isPresent()) {

            //todo aqui llamar el metodo para restarle a peso muestra y cambiar status

            Sample sample = existingSample.get();
            newCountSample=sample.getSampleWeight()-roastDto.getRoastWeight();
            if (newCountSample>=0){
                sample.setSampleStatus(statusSample);
                sample.setSampleWeight(newCountSample);

                 roast = Roast.buildFromDto(this.roastMapper.dtoToRoast(roastDto), sample);
                List<Temperature> listTemperatures = new ArrayList<>();
                for (Temperature tempDto : roastDto.getRoastTemperature()) {
                    Temperature temperature = Temperature.buildFromDto(tempDto);
                    temperature.setRoast(roast);
                    listTemperatures.add(temperature);
                }

                roast.setRoastTemperature(listTemperatures);
                roast = this.roastRepository.save(roast);


            }else {
                System.out.println("El peso de la muestra no puede ser negativo o cero.");
                return null; // Devolver null si el nuevo peso no es válido
            }
            return roastMapper.roastToDto(roast);

        } else {
            System.out.println("La muestra no se encuentra");
            return null;
        }
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
            existingRoast.setRoastWeight(roastDto.getRoastWeight());
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

        boolean existenTemperatures=temperatureListBaseDatos.size()==getTemperatureDto.size();//no tiene sentido
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

//    @Override
//    public List<RoastDto> getAllRoast() {
//        List<Roast> roastss=roastRepository.findAll();
//        for (Roast roast : roastss) {
//            // Verifica que roast.getRoastTemperature() no sea null
//            if (roast.getRoastTemperature() != null) {
//                roast.getRoastTemperature().sort(Comparator.comparing(Temperature::getTemperature_minute));
//            }
//        }
//        return roastMapper.roastToDto(roastss);
//    }


    public Page<RoastDto> getRoastsBySampleNumeroMuestra(String sampleNumeroMuestra, Pageable pageable) {


        Page<Roast> roastPage = roastRepository.findBySample_sampleNumeroMuestraContainingIgnoreCaseAndRoastStatus(sampleNumeroMuestra,"sinSesion", pageable);


        roastPage.getContent().forEach(roast ->
                roast.getRoastTemperature().sort(
                        (temp1, temp2) -> Double.compare(temp1.getTemperature_minute(), temp2.getTemperature_minute())
                )
        );
        // Convertir el contenido del Page usando el mapper
        List<RoastDto> roastDtoList = roastMapper.roastToDto(roastPage.getContent());






        // Crear un nuevo Page<RoastDto> con el contenido convertido
        return new PageImpl<>(roastDtoList, pageable, roastPage.getTotalElements());
    }



    public Page<RoastDto> getRoastsBySampleNumeroMuestraAll(String sampleNumeroMuestra, Pageable pageable) {


        Page<Roast> roastPage = roastRepository.findBySample_sampleNumeroMuestraContainingIgnoreCase(sampleNumeroMuestra, pageable);


        roastPage.getContent().forEach(roast ->
                roast.getRoastTemperature().sort(
                        (temp1, temp2) -> Double.compare(temp1.getTemperature_minute(), temp2.getTemperature_minute())
                )
        );
        // Convertir el contenido del Page usando el mapper
        List<RoastDto> roastDtoList = roastMapper.roastToDto(roastPage.getContent());






        // Crear un nuevo Page<RoastDto> con el contenido convertido
        return new PageImpl<>(roastDtoList, pageable, roastPage.getTotalElements());
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
