package br.com.fiap.techchallengegrupo01.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletrodomesticoResponseDto {

    private Long id;
    private String tipo;
    private String modelo;
    private String marca;
    private Integer potencia;
    private EnderecoResponseIdDTO endereco;
}
