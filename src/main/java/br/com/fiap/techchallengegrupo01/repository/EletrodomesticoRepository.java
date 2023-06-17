package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class EletrodomesticoRepository {

    private final Set<EletrodomesticoModel> dao = new HashSet<>();

    public EletrodomesticoModel save(EletrodomesticoModel model){

        model.setId((long) dao.size() + 1);
        dao.add(model);
        return model;
    }

    public Set<EletrodomesticoModel> getAll(){
        return dao;
    }

    public EletrodomesticoModel getById(Long id){

        var response = dao.stream().filter(x -> x.getId().equals(id)).toList();

        return !response.isEmpty() ? response.get(0) : null;
    }
}
