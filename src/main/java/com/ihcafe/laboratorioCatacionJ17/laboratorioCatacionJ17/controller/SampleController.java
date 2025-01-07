package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;



import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.SampleDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.ProducerRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.SampleRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.BaseResponse;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.response.Response;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.SampleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/Sample")
@RequiredArgsConstructor
public class SampleController {
    private  final SampleService sampleService;
    private  final ProducerRepository producerRepository;
    private final SampleRepository sampleRepository;
    @PostMapping("/{producerId}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('WRITING_SAMPLE')")
    public ResponseEntity<? extends Response<SampleDto>> saveRoast(
            @PathVariable("producerId")String producerId,
            @Valid @RequestBody  SampleDto sampleDto) {
        SampleDto savedSample = sampleService.saveSample(producerId,sampleDto);
        BaseResponse<SampleDto> sampleBaseResponse = new BaseResponse<>();
        return sampleBaseResponse
                .buildResponseEntity(HttpStatus.CREATED, "Rast saved successfully", savedSample);

    }

    @PutMapping("/{sampleId}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PreAuthorize("hasAuthority('UPDATE_SAMPLE')")
    public ResponseEntity<? extends Response<SampleDto>> updateSample(
            @PathVariable("sampleId") String sampleId,
            @RequestBody @Valid SampleDto sampleDto) {
        SampleDto updatedSample = sampleService.updateSample(sampleId, sampleDto);
        BaseResponse<SampleDto> response = new BaseResponse<>();
        return response
                .buildResponseEntity(HttpStatus.OK, "Sample updated successfully", updatedSample);
    }
    @GetMapping(value = "/lista/{statu}")
    @PreAuthorize("hasAuthority('READ_SAMPLE')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<SampleDto>> findAll(
            @PathVariable("statu") String statu
    ) {
        List<SampleDto> retrievedSample = sampleService.getAllSample(statu);

        // Devolver la lista de productores en la respuesta con código 200 OK
        return new ResponseEntity<>(retrievedSample, HttpStatus.OK);
    }

    @GetMapping(value = "/{farmId}/lista")
    @PreAuthorize("hasAuthority('READ_SAMPLE')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<SampleDto>> findAllFarmId(
            @PathVariable("farmId") String farmId
    ) {
        List<SampleDto> retrievedSample = sampleService.getFarmId(farmId);

        return new ResponseEntity<>(retrievedSample, HttpStatus.OK);
    }


    @GetMapping("/nextSampleNumber")
    @PreAuthorize("hasAuthority('READ_SAMPLE')")
    public ResponseEntity<Map<String, String>> getNextSampleNumber() {

        String currentYear = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
        String maxSample = sampleRepository.findNextSampleNumber();


        if (maxSample == null) {
            // Si no hay muestras para el año actual, comenzamos con 0001
            System.out.println("ando en null");
            maxSample = currentYear + "0001";
        } else {

            String anioCafetalero = maxSample.substring(0,4);
            int correlativo=Integer.parseInt(maxSample.substring(5,8));
            maxSample = anioCafetalero +'-'+ String.format("%04d", correlativo);//PARA QUE ACEPTE CERO A LA IZQUIERDA
            System.out.println(anioCafetalero);
        }
        String maxSampleSTRING = (maxSample);

        Map<String, String> response = new HashMap<>();
        response.put("nexSampleNumber", maxSampleSTRING);
        // Usar el DTO para devolver la respuesta
       //
        return ResponseEntity.ok().body(response);
    }


}
