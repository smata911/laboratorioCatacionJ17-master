package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="tblTypeProcess" )
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeProcess {

    @Id
    @Column(name = "typeProcess_id",nullable = false,length = 1)
    private int typeProcessId;

    @Column(name = "typeProcess_name",nullable = false,length = 25)
    private  String typeProcessName;

    @OneToMany(mappedBy ="typeProcess",
            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Sample> typeProcessSample=new ArrayList<>();
}
