package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTiempoDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ModeloTiempos;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.ModeloTiempoMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ModeloTiempoRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ModeloTiempoService;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.ModeloTuesteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ModeloTiempoServiceImpl implements ModeloTiempoService {

    private final ModeloTiempoRepository modeloTiemposRepository;
    private final ModeloTiempoMapper modeloTiempoMapper;

    @Override
    public ModeloTiempoDto updateModeloTiempo(String modeloTiempoId, ModeloTiempoDto modelo) {
        Optional<ModeloTiempos> existigModeloTiempo=modeloTiemposRepository.findById(modeloTiempoId);
        System.out.println(existigModeloTiempo.isPresent()+"squi");
        ModeloTiempos modeloTiempos=null;
        if(existigModeloTiempo.isPresent()){
            modeloTiempos=existigModeloTiempo.get();
            modeloTiempos.setModeloTiempoValue(modelo.getModeloTiempoValue());
            modeloTiempos.setModeloTiempoTemperatura(modelo.getModeloTiempoTemperatura());

        }
        this.modeloTiemposRepository.save(modeloTiempos);


        return modeloTiempoMapper.ModeloTiemposToDto(modeloTiempos);
    }
}
