package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.EmpresaDto;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Empresa;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {


    @Override
    public EmpresaDto saveEmpresa(EmpresaDto empresaDto) {
        return null;
    }
}
