package br.com.fiap.techchallengegrupo01.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRequestDTO {

    private String nome;
    private String dataNascimento;
    private String sexo;
    private String parentesco;
}
