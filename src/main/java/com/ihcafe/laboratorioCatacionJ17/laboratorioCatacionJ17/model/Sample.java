package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tblSample")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sample {

    @Id
    @Column(name = "sample_id",nullable = false,length = 64)
    private String sampleId;

    @Column(name = "sample_NumeroMuestra",nullable = false,length = 9)
    private String sampleNumeroMuestra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    @JsonBackReference // Evita el bucle recursivo
    private Farm farm;

    @Column(name = "sample_weight",nullable = false)
    private double sampleWeight;

    @Column(name = "sample_porcentage_humidity",nullable = false)
    private  double samplePercentageHumidity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeSample_id")
    private TypeSample typeSample;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeProcess_id")
    private TypeProcess typeProcess;

    @Column(name = "sample_date",nullable = false)
    private  String sampleDate;

    @Column(name = "sample_status")
    private String sampleStatus;

    /*relacion de quien lo inserto*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeMarket_id")
    private TypeMarket  typeMarket;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tblHvarietiesSample",
            joinColumns = @JoinColumn(name = "sample_id"),
            inverseJoinColumns = @JoinColumn(name = "varieties_id")
    )
    @Builder.Default
    private List<Varieties> varietiesSample=new ArrayList<>();


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "tblHestudiesSample",
            joinColumns = @JoinColumn(name = "sample_id"),
            inverseJoinColumns = @JoinColumn(name = "estudies_id")
    )
    @Builder.Default
  //  @JsonManagedReference // Agrega esta anotación
    private List<Estudies> estudiesSample=new ArrayList<>();

    @OneToMany(mappedBy = "sample", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    //@JsonManagedReference // o @JsonIgnore si no necesitas serializar la relación
    @JsonIgnore
    @Builder.Default
    private List<Roast> sampleRoast = new ArrayList<>();

    public static Sample buildFromDto(Sample sample, Farm farm, List<Varieties> variedadesList,List<Estudies> estudiesList) {
        sample.setSampleId(UUID.randomUUID().toString());
        sample.setFarm(farm);
        sample.setVarietiesSample(variedadesList);
        sample.setEstudiesSample(estudiesList);



        return sample;
    }

}
