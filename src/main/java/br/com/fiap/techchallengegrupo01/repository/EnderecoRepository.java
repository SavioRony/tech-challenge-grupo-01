package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EnderecoRepository {

    private final Set<EnderecoModel> dao = new HashSet<>();

    public EnderecoModel save(EnderecoModel enderecoModel) {

        enderecoModel.setId((long)dao.size()+1);
        dao.add(enderecoModel);
        return enderecoModel;
    }

    public Set<EnderecoModel> getAll(){
        return dao;
    }

    public EnderecoModel getById(Long id){

        var response = dao.stream().filter(x -> x.getId().equals(id)).toList();

        return !response.isEmpty() ? response.get(0) : null;
    }
}
