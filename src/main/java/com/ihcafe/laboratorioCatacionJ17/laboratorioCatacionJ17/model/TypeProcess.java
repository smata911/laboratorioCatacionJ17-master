package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="tblTypeProcess" )
public class TypeProcess {

    @Id
    @Column(name = "typeProcess_id",nullable = false,length = 1)
    private int typeProcessI;

    @Column(name = "typeProcess_name",nullable = false,length = 25)
    private  String typeProcessName;

    @OneToMany(mappedBy ="typeProcess",
            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Sample> typeProcessSample=new ArrayList<>();
}
