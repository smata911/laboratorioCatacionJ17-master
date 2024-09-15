package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="tblVarieties")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Varieties {

    @Id
    @Column(name ="varieties_id",length = 64)
    private String varietiesId;

    @Column(name = "varieties_name",length = 35)
    private String varietiesName;

    @Column(name = "varieties_scientific",length = 40)
    private String varietiesScientific;

    @ManyToMany(mappedBy = "varietiesSample")
    private List<Sample> sampleVarieties=new ArrayList<>();



//    @ManyToMany(mappedBy = "varietiesSample",
//            fetch = FetchType.EAGER,
//            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
//    @Builder.Default
//    private List<Sample> sampleVarieties=new ArrayList<>();

    //public static Varieties buildFromDto(Varieties varieties){
    //    varieties.setVarietiesId(UUID.randomUUID().toString());
        //producer.setProducerStatus(ModelStatus.ACTIVE);
    //    return varieties;
   // }
}
