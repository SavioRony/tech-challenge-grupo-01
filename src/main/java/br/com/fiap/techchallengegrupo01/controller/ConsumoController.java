package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.ConsumoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.ConsumoRequestEletrodomesticoDTO;
import br.com.fiap.techchallengegrupo01.model.ConsumoModel;
import br.com.fiap.techchallengegrupo01.service.ConsumoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos")
@Tag(name = "Consumos", description = "Serviço para gestão de consumo dos eletrodomesticos")
public class ConsumoController {


    @Autowired
    private ConsumoService service;

    @PostMapping("")
    @Operation(summary = "Cadastro consumo", description = "Cadastro de consumo",
            tags = {"Consumo"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ConsumoModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<?> saveConsumo(@RequestBody @Valid ConsumoRequestDTO requestDTO) {

        Boolean response = service.saveConsumoEletrodomestico(requestDTO);
        return response ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{idEletrodomestico}")
    @Operation(summary = "Lista de consumo", description = "Lista de consumo",
            tags = {"Consumo"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ConsumoModel.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<List<ConsumoModel>> getAll(@PathVariable Long idEletrodomestico) {

        List<ConsumoModel> response = service.findConsumo(idEletrodomestico);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }
}
