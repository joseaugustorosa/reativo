package com.jose.reativo.controller;

import com.jose.reativo.model.Veiculo;
import com.jose.reativo.service.ExternoService;
import com.jose.reativo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VeiculosController {

    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private ExternoService externoService;


    @GetMapping
    public Flux<Veiculo> listar() {
        return veiculoService.findAll();
    }
    @GetMapping("/api")
    public Mono<String> api() {
        return externoService.fetchData();
    }
    @GetMapping("/{id}")
    public Mono<Veiculo> find(@RequestBody Long id) {
        return veiculoService.findById(id);
    }
    @PostMapping
    public Mono<Veiculo> criar(@RequestBody Veiculo veiculo) {
        return veiculoService.save(veiculo);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deletar(@RequestBody Long id) {
        return veiculoService.delete(id);
    }

}
