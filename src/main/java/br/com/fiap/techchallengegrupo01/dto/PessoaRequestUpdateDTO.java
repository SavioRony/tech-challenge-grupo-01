package br.com.fiap.techchallengegrupo01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRequestUpdateDTO {

    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "Data de nascimento não pode ser nulo ou vazio")
    private String dataNascimento;
    @NotBlank(message = "Sexo não pode ser nulo ou vazio")
    private String sexo;
    private String parentesco;
    @NotNull(message = "Id de usuario não pode ser nulo ou vazio")
    private Long idEndereco;
}
