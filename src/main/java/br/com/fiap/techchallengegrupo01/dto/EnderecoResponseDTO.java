package br.com.fiap.techchallengegrupo01.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponseDTO {

    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String numero;
    private UsuarioResponseIdDTO usuario;
}
