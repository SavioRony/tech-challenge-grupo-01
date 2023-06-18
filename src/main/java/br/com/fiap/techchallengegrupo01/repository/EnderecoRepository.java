package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private final Set<EnderecoModel> dao = new HashSet<>();

    private int idSequencie = 1;

    public EnderecoModel save(EnderecoModel enderecoModel) {

        enderecoModel.setId((long)idSequencie);
        idSequencie++;
        dao.add(enderecoModel);
        return enderecoModel;
    }

    public Set<EnderecoModel> getAll(){
        return dao.stream().sorted(Comparator.comparing(EnderecoModel::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public EnderecoModel getById(Long id){

        var response = dao.stream().filter(x -> x.getId().equals(id)).toList();

        return !response.isEmpty() ? response.get(0) : null;
    }

    public EnderecoModel update(EnderecoModel modelUpdated, Long id){

        var model = getById(id);

        if(model != null){

            modelUpdated.setId(model.getId());
            dao.remove(model);
            dao.add(modelUpdated);

            return modelUpdated;
        }
        return null;
    }

    public Long delete (Long id){

        var model = getById(id);

        if(model != null){
            dao.remove(model);
            return  id;
        }
        return null;
    }
}
