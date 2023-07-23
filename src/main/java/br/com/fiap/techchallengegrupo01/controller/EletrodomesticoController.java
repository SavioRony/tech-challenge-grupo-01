package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.service.EletrodomesticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/eletrodomesticos")
@Tag(name = "Eletrodomestico", description = "Serviço para gestão de eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    public EletrodomesticoService service;

    @GetMapping("")
    @Operation(summary = "Lista de eletrodomesticos", description = "Lista de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EletrodomesticoModel.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<Set<EletrodomesticoModel>> getAll(){
        var response = service.getAll();

        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta por ID de eletrodomesticos", description = "Consulta por ID de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EletrodomesticoModel.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EletrodomesticoModel> getById(@PathVariable(name = "id") Long id){

        var response = service.getById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    @Operation(summary = "Cadastro de eletrodomesticos", description = "Cadastro de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EletrodomesticoModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<EletrodomesticoModel> create(
            @RequestBody @Valid EletrodomesticoRequestDTO dto){
        var response = service.save(dto);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alteração de eletrodomesticos", description = "Alteração de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EletrodomesticoModel.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EletrodomesticoModel> update(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid EletrodomesticoRequestDTO dto){

        var response = service.update(dto, id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclusão de eletrodomesticos", description = "Exclusão de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){

        var response = service.delete(id);

        return response != null ?
                ResponseEntity.status(HttpStatusCode.valueOf(200)).build() :
                ResponseEntity.notFound().build();
    }
}
