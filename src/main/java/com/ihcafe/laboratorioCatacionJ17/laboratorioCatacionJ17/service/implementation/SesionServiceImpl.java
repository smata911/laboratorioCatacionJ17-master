package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SesionDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Roast;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Sesion;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.SesionesTueste;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.mapper.SesionMapper;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.RoastRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SesionRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SesionServiceImpl implements SesionService {
    private final SesionRepository sesionRepository;
    private  final SesionMapper sesionMapper;
    private  final RoastRepository roastRepository;
    private String ROAST_STATUS="conSesion";
    Sesion sesion=null;
    @Override
    public SesionDto saveSesion(SesionDto sesionDto) {
       String statusSesion="SIN INICIAR";


      sesion=Sesion.buildFromDto(sesionDto);


        List<SesionesTueste> sesionesTuesteList = new ArrayList<>();
        for (SesionesTueste tuesteDto : sesionDto.getSesionesTueste()) {
            SesionesTueste sesionesTueste = new SesionesTueste();
            sesionesTueste.setSesionesTuesteId(UUID.randomUUID().toString());
            sesionesTueste.setSesiones(sesion);


            // Aquí verificas si el roastId es válido y si puedes obtener el objeto Roast
            if (tuesteDto.getRoast().getRoastId() != null) {
                Optional<Roast> optionalRoast = roastRepository.findById(tuesteDto.getRoast().getRoastId());
                if (optionalRoast.isPresent()) {
                    Roast   roat=optionalRoast.get();

                    sesionesTueste.setRoast(optionalRoast.get());
                    roat.setRoastStatus(ROAST_STATUS);
                } else {
                    throw new IllegalArgumentException("Roast no encontrado con ID: " + tuesteDto.getRoast().getRoastId());
                }
            } else {
                throw new IllegalArgumentException("El ID de Roast no puede ser nulo");
            }

            sesionesTuesteList.add(sesionesTueste);
        }
        sesion.setSesionesStatus(statusSesion);
        sesion.setSesionesTueste(sesionesTuesteList);

        sesion = sesionRepository.save(sesion);





        return sesionMapper.sesionToDto(sesion);
    }


    @Override
    public List<SesionDto> getAllSesion() {

        List<Sesion> varieties = sesionRepository.findAll();
        //System.out.println(varieties.);
        return sesionMapper.sesionToDto(varieties);

    }
}
