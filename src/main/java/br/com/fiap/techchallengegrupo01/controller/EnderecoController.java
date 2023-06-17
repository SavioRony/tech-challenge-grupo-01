package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoModel> saveEndereco(@RequestBody @Valid EnderecoRequestDTO requestDTO) {

        var response = service.saveEndereco(requestDTO);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    public ResponseEntity<Set<EnderecoModel>> getAll(){

        var response = service.getAll();

        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> getById(@PathVariable(name = "id") Long id){

        var response = service.getAll(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
