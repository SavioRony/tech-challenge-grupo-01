package br.com.fiap.techchallengegrupo01.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EnderecoModel {

    private Long id;
    @NotBlank(message = "Rua não pode ser nulo ou vazio")
    private String rua;
    @NotBlank(message = "Bairro não pode ser nulo ou vazio")
    private String bairro;
    @NotBlank(message = "Cidade não pode ser nulo ou vazio")
    private String cidade;
    @NotBlank(message = "Estado não pode ser nulo ou vazio")
    private String estado;
    @Pattern(regexp = "\\d{8}", message = "O CEP deve estar no formato 99999999")
    private String cep;
    private String numero;
}
