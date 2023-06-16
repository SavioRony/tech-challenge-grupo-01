package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {
    public PessoaModel save(PessoaModel pessoaModel){
        return pessoaModel;
    }
}
