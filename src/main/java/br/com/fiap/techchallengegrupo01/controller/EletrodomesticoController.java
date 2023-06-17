package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.service.EletrodomesticoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/eletrodomestico")
public class EletrodomesticoController {

    @Autowired
    public EletrodomesticoService service;

    @GetMapping("")
    public ResponseEntity<Set<EletrodomesticoModel>> getAll(){
        var response = service.getAll();

        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoModel> getById(@PathVariable(name = "id") Long id){

        var response = service.getById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<EletrodomesticoModel> create(
            @RequestBody @Valid EletrodomesticoRequestDTO dto){
        var response = service.save(dto);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
}
