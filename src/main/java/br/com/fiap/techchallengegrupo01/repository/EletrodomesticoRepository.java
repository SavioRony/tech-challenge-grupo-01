package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@Repository
public class EletrodomesticoRepository {

    private final Set<EletrodomesticoModel> dao = new HashSet<>();
    
    private int idSequencie = 1;

    public EletrodomesticoModel save(EletrodomesticoModel model){

        model.setId((long) idSequencie);
        idSequencie++;
        dao.add(model);
        return model;
    }

    public Set<EletrodomesticoModel> getAll(){
        return new HashSet<>(dao.stream().sorted(Comparator.comparing(EletrodomesticoModel::getId)).toList());
    }

    public EletrodomesticoModel getById(Long id){

        var response = dao.stream().filter(x -> x.getId().equals(id)).toList();

        return !response.isEmpty() ? response.get(0) : null;
    }

    public EletrodomesticoModel update(EletrodomesticoModel modelUpdated, Long id){

        var model = getById(id);

        if(model != null){

            modelUpdated.setId(model.getId());
            dao.remove(model);
            dao.add(modelUpdated);
            return modelUpdated;
        }

        return null;
    }

    public Long delete(Long id){

        var model = getById(id);
        if(model != null){
            dao.remove(model);
            return id;
        }
        return null;
    }
}
