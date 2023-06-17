package br.com.fiap.techchallengegrupo01.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaModel {

    private Long id;
    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "Data de nacimento não pode ser nulo ou vazio")
    private String dataNascimento;
    @NotBlank(message = "Sexo não pode ser nulo ou vazio")
    private String sexo;
    private String parentesco;
}
