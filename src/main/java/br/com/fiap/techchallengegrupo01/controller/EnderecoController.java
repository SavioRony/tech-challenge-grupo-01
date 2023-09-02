package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestUpdateDTO;
import br.com.fiap.techchallengegrupo01.dto.EnderecoResponseDTO;
import br.com.fiap.techchallengegrupo01.mapper.EnderecoMapper;
import br.com.fiap.techchallengegrupo01.service.EnderecoService;
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
@RequestMapping("/enderecos")
@RequiredArgsConstructor
@Tag(name = "Endereço", description = "Serviço para gestão de endereços")
public class EnderecoController {
    @Autowired
    private EnderecoService service;
    private final EnderecoMapper mapper;

    @PostMapping
    @Operation(summary = "Cadastro de endereços", description = "Cadastro de endereços",
            tags = {"Endereço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EnderecoResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<EnderecoResponseDTO> saveEndereco(@RequestBody @Valid EnderecoRequestDTO requestDTO) {

        var response = service.saveEndereco(requestDTO);
        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    @Operation(summary = "Lista de endereços", description = "Lista de endereços",
            tags = {"Endereço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoResponseDTO.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<Set<EnderecoResponseDTO>> getAll(
            @RequestParam(value = "_q", required = false) String _q) {

        var response = service.getAll(_q);

        return !response.isEmpty() ? ResponseEntity.ok(mapper.toResponseDtoAll(response)) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta por ID de endereços", description = "Consulta por ID de endereços",
            tags = {"Endereço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EnderecoResponseDTO.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EnderecoResponseDTO> getById(@PathVariable(name = "id") Long id) {

        var response = service.getById(id);

        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alteração de endereços", description = "Alteração de endereços",
            tags = {"Endereço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EnderecoResponseDTO.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EnderecoResponseDTO> update(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid EnderecoRequestUpdateDTO dto) {

        var response = service.update(dto, id);

        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclusão de endereços", description = "Exclusão de endereços",
            tags = {"Endereço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {

        var response = service.delete(id);

        return response != null ?
                ResponseEntity.status(HttpStatusCode.valueOf(200)).build() :
                ResponseEntity.notFound().build();
    }
}
