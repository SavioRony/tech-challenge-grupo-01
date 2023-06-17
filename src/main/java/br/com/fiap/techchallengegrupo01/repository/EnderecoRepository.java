package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoRepository {
    public EnderecoModel save(EnderecoModel enderecoModel) {
        return enderecoModel;
    }
}
