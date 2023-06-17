package br.com.fiap.techchallengegrupo01.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoModel {

    @NotBlank(message = "Rua não pode ser nulo ou vazio")
    private String rua;
    @NotBlank(message = "Bairro não pode ser nulo ou vazio")
    private String bairro;
    @NotBlank(message = "Cidade não pode ser nulo ou vazio")
    private String cidade;
    @NotBlank(message = "Estado não pode ser nulo ou vazio")
    private String estado;
    @NotBlank(message = "Estado não pode ser nulo ou vazio")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve estar no formato 99999999")
    private String cep;
    private String numero;
}
