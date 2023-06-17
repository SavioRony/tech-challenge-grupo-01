package br.com.fiap.techchallengegrupo01.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EletrodomesticoModel {

    private Long id;

    private String tipo;

    private String modelo;

    private String marca;

    private Integer potencia;
}
