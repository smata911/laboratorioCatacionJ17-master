package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.EmpresaDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmpresaService  {

    EmpresaDto saveEmpresa(EmpresaDto empresaDto);


}
