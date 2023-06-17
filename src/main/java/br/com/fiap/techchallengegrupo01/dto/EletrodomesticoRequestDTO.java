package br.com.fiap.techchallengegrupo01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoRequestDTO {

    @NotBlank(message = "tipo do eletrodomestico não pode ser nulo ou vazio")
    private String tipo;

    @NotBlank(message = "modelo de eletrodomestico não pode ser nulo ou vazio")
    private String modelo;

    @NotBlank(message = "marca do eletrodomestico não pode ser nulo ou vazia")
    private String marca;

    @NotNull
    private Integer potencia;
}
