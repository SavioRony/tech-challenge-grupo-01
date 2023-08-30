package br.com.fiap.techchallengegrupo01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_enderecos")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "endereco")
    private List<EletrodomesticoModel> eletrodomesticos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "endereco")
    private List<PessoaModel> pessoas;
}
