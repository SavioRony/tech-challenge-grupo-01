package br.com.fiap.techchallengegrupo01.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder(value = {"id"})
public class PessoaResponseDTO {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String parentesco;
    private EnderecoResponseIdDTO endereco;
    private UsuarioResponseIdDTO usuario;
}
