package br.com.fiap.techchallengegrupo01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumoRequestDTO {

    private Long idEletrodomestico;
    private Date data;
    private int horasConsumo;
}
