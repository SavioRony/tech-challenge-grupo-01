package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PessoaRepository {

    private final Set<PessoaModel> dao = new HashSet<>();

    public PessoaModel save(PessoaModel pessoaModel){

        pessoaModel.setId((long)dao.size()+1);
        dao.add(pessoaModel);
        return pessoaModel;
    }

    public Set<PessoaModel> getAll(){
        return dao;
    }

    public PessoaModel getById(Long id){
        var response = dao.stream().filter(x -> x.getId().equals(id)).toList();

        return !response.isEmpty() ? response.get(0) : null;
    }
}
