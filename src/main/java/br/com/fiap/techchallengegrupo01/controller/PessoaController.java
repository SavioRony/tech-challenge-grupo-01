package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import br.com.fiap.techchallengegrupo01.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping("")
    public ResponseEntity<PessoaModel> savePessoas(@RequestBody @Valid PessoaRequestDTO requestDTO) {

       var response  = service.savePessoa(requestDTO);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    public ResponseEntity<Set<PessoaModel>> getAll(){

        var response = service.getAll();

        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> getById(@PathVariable(name = "id") Long id){

        var response = service.getById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
