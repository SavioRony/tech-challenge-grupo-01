package br.com.fiap.techchallengegrupo01.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaModel {

    @NotNull
    private String nome;
    @NotNull
    private String dataNascimento;
    @NotNull
    private String sexo;
    @NotNull
    private String parentesco;
}
