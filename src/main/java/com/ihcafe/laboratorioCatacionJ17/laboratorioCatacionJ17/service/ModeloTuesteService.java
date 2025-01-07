package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTiempoDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTuesteDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.VarietiesDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ModeloTuesteService {

 //List<ModeloTuesteDto> saveModeloTueste(String typeProcessId,ModeloTuesteDto modelo);
ModeloTuesteDto saveModeloTueste(ModeloTuesteDto modelo);


 ModeloTuesteDto findByModeloTypeProces(int typeProcessId,String modeloVariedad,int modeloStatus );

 List<ModeloTuesteDto>getAllModelos();


}
