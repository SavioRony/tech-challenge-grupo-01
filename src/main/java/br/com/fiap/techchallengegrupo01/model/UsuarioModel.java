package br.com.fiap.techchallengegrupo01.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "Data de nacimento não pode ser nulo ou vazio")
    private String dataNascimento;
    @NotBlank(message = "Sexo não pode ser nulo ou vazio")
    private String sexo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonBackReference
    private List<PessoaModel> pessoas;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonBackReference
    private List<EnderecoModel> enderecos;
}
