package com.jose.reativo.service;

import com.jose.reativo.model.Veiculo;
import com.jose.reativo.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class VeiculoService {
    @Autowired
    private VeiculosRepository veiculosRepository;

    public Flux<Veiculo> findAll(){
        return veiculosRepository.findAll();
    }
    public Mono<Veiculo> findById(Long id){
        return  veiculosRepository.findById(Math.toIntExact(id));
    }
    public Mono<Veiculo> save(Veiculo veiculo){
        return veiculosRepository.save(veiculo);
    }
    public Mono<Void> delete(Long id){
        return veiculosRepository.deleteById(Math.toIntExact(id));
    }

}
