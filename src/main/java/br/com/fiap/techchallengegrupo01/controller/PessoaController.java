package br.com.fiap.techchallengegrupo01.controller;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.PessoaRequestUpdateDTO;
import br.com.fiap.techchallengegrupo01.dto.PessoaResponseDTO;
import br.com.fiap.techchallengegrupo01.mapper.PessoaMapper;
import br.com.fiap.techchallengegrupo01.service.PessoaService;
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
@RequestMapping("/pessoas")
@Tag(name = "Pessoa", description = "Serviço para gestão de pessoas")
@RequiredArgsConstructor
public class PessoaController {
    @Autowired
    private PessoaService service;

    private final PessoaMapper mapper;

    @PostMapping("")
    @Operation(summary = "Cadastro de pessoas", description = "Cadastro de pessoas",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaRequestDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<PessoaResponseDTO> savePessoas(
            @RequestBody @Valid PessoaRequestDTO requestDTO) {

        var response = service.savePessoa(requestDTO);
        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    @Operation(summary = "Lista de pessoas", description = "Lista de pessoas",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = PessoaResponseDTO.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<Set<PessoaResponseDTO>> getAll(
            @RequestParam(value = "_q", required = false) String _q) {

        var response = service.getAll(_q);

        return !response.isEmpty() ? ResponseEntity.ok(mapper.toResponseDtoAll(response)) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta por ID de pessoas", description = "Consulta por ID de pessoas",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<PessoaResponseDTO> getById(@PathVariable(name = "id") Long id) {

        var response = service.getById(id);
        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alteração de pessoas", description = "Alteração de pessoas",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<PessoaResponseDTO> update(@PathVariable(name = "id") Long id,
                                              @RequestBody @Valid PessoaRequestUpdateDTO dto) {

        var response = service.update(dto, id);
        return response != null ? ResponseEntity.ok(mapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclusão de pessoas", description = "Exclusão de pessoas",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {

        var response = service.delete(id);

        return response != null ?
                ResponseEntity.status(HttpStatusCode.valueOf(200)).build() :
                ResponseEntity.notFound().build();
    }
}
