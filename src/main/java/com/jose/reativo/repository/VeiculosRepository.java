package com.jose.reativo.repository;

import com.jose.reativo.model.Veiculo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface VeiculosRepository extends R2dbcRepository<Veiculo,Integer> {
}
