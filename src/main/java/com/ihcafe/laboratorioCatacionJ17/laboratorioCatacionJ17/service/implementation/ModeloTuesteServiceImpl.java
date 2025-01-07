package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTiempoDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTuesteDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ProducerDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception.ProducerNotFoundException;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.*;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.ModeloTuesteMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ModeloTiempoRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ModeloTuesteRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.TypeProcessRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ModeloTuesteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModeloTuesteServiceImpl implements ModeloTuesteService {

    private final ModeloTuesteMapper modeloTuesteMapper;
    private final ModeloTuesteRepository modeloTuesteRepository;
   // private final ModeloTiempoRepository modeloTiemposRepository;
    private final TypeProcessRepository typeProcessRepository;



    @Override
    public ModeloTuesteDto saveModeloTueste( ModeloTuesteDto modeloTuesteDto) {
        System.out.println("ModeloTueste recibido:");
        System.out.println(modeloTuesteDto.getModeloTiempos().size()+"aquiii");
        ModelosTueste savedModelosTueste=null;
        Optional<TypeProcess> existingProcess=typeProcessRepository.findById(String.valueOf(modeloTuesteDto.getTypeProcess().getTypeProcessId()));
        typeProcessRepository.findById(String.valueOf(modeloTuesteDto.getTypeProcess().getTypeProcessId()));
if (existingProcess.isPresent()){

    // Obtén la lista de modelos desde el DTO
    ModelosTueste modelosTueste =ModelosTueste.buildFromDto(this.modeloTuesteMapper.dtoToModeloTueste(modeloTuesteDto));
    modelosTueste.setTypeProcess(modeloTuesteDto.getTypeProcess());
    //List<ModelosTueste> savedModelosTuesteList = this.modeloTuesteRepository.saveAll(modelosTuesteList);
  savedModelosTueste = this.modeloTuesteRepository.save(modelosTueste);


}


        // Retorna la lista de DTOs convertidos desde la lista guardada
        return modeloTuesteMapper.modeloTuesteToDto(savedModelosTueste);
    }




    public  ModeloTuesteDto findByModeloTypeProces(int typeProcessId,String modeloVariedad,int modeloStatus) {
       ModelosTueste modelosTueste = modeloTuesteRepository.findByModeloVariedadAndModeloStatusAndTypeProcessId(typeProcessId,modeloVariedad,modeloStatus);


        return modeloTuesteMapper.modeloTuesteToDto(modelosTueste);
   }

    @Override
    public List<ModeloTuesteDto> getAllModelos() {
        List<ModelosTueste> modelos = modeloTuesteRepository.findAll();

        for (ModelosTueste modelo : modelos) {
            // Ordenar los tiempos del modelo por modeloTiempoValue
            modelo.getModeloTiempos().sort(Comparator.comparingDouble((ModeloTiempos t) -> t.getModeloTiempoValue() == 0 ? Double.NEGATIVE_INFINITY : t.getModeloTiempoValue()));
        }



        return modeloTuesteMapper.modelosToDtos(modelos);
    }


}
