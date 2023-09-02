package br.com.fiap.techchallengegrupo01.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_pessoas")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "Data de nacimento não pode ser nulo ou vazio")
    private String dataNascimento;
    @NotBlank(message = "Sexo não pode ser nulo ou vazio")
    private String sexo;
    private String parentesco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private EnderecoModel endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference
    private UsuarioModel usuario;
}
