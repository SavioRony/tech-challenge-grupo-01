package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoResponseDto;
import br.com.fiap.techchallengegrupo01.mapper.EletrodomesticoMapper;
import br.com.fiap.techchallengegrupo01.service.EletrodomesticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/eletrodomesticos")
@RequiredArgsConstructor
@Tag(name = "Eletrodomestico", description = "Serviço para gestão de eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private EletrodomesticoService service;
    private final EletrodomesticoMapper mapper;

    @GetMapping("")
    @Operation(summary = "Lista de eletrodomesticos", description = "Lista de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EletrodomesticoResponseDto.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<Set<EletrodomesticoResponseDto>> getAll(
            @RequestParam(value = "_q", required = false) String _q) {
        var response = service.getAll(_q);

        return !response.isEmpty() ? ResponseEntity.ok(mapper.toResponseDtoAll(response)) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta por ID de eletrodomesticos", description = "Consulta por ID de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EletrodomesticoResponseDto.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EletrodomesticoResponseDto> getById(@PathVariable(name = "id") Long id){

        var response = service.getById(id);

        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    @Operation(summary = "Cadastro de eletrodomesticos", description = "Cadastro de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EletrodomesticoResponseDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<EletrodomesticoResponseDto> create(
            @RequestBody @Valid EletrodomesticoRequestDTO dto){
        var response = service.save(dto);
        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alteração de eletrodomesticos", description = "Alteração de eletrodomesticos",
            tags = {"Eletrodomestico"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EletrodomesticoResponseDto.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EletrodomesticoResponseDto> update(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid EletrodomesticoRequestDTO dto){

        var response = service.update(dto, id);

        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.notFound().build();
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
