package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.ModeloTuesteDto;
import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "tblModelosTueste")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelosTueste {

    @Id
    @Column(name = "modelo_id", nullable = false, length = 64)
    private String modeloId;

    @Column(name = "modelo_variedad", nullable = false, length = 25)
    private String modeloVariedad;

    @Column(name = "modelo_Status", nullable = false)
    private int modeloStatus;

    @ManyToOne
    @JoinColumn(name = "typeProcess_id", referencedColumnName = "typeProcess_id")
    @JsonBackReference
    private TypeProcess typeProcess;

    //@OneToMany(mappedBy = "modelosTueste", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @OneToMany(mappedBy = "modelosTueste", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @Builder.Default
//    private List<ModeloTiempos> modeloTiempos = new ArrayList<>();

    @OneToMany(mappedBy = "modelosTueste", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Esta anotación está bien aquí
    @Builder.Default
    private List<ModeloTiempos> modeloTiempos = new ArrayList<>();

    // Método para construir la entidad desde el DTO
    public static ModelosTueste buildFromDto(ModelosTueste modelosTueste) {
        modelosTueste.setModeloId(UUID.randomUUID().toString());
        System.out.println(modelosTueste.getModeloVariedad() + " es la variedad");
        System.out.println(modelosTueste.getModeloTiempos().size() + " es el tamaño");

        for (ModeloTiempos tiempo : modelosTueste.getModeloTiempos()) {
            tiempo.setModelosTueste(modelosTueste);
            tiempo.setModeloTiempoTiempoId(UUID.randomUUID().toString());
        }

        return modelosTueste;
    }
}