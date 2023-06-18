package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@Repository
public class PessoaRepository {

    private final Set<PessoaModel> dao = new HashSet<>();
    private int idSequencie = 1;

    public PessoaModel save(PessoaModel pessoaModel){

        pessoaModel.setId((long)idSequencie);
        idSequencie++;
        dao.add(pessoaModel);
        return pessoaModel;
    }

    public Set<PessoaModel> getAll(){
        return new HashSet<>(dao.stream().sorted(Comparator.comparing(PessoaModel::getId)).toList());
    }

    public PessoaModel getById(Long id){
        var response = dao.stream().filter(x -> x.getId().equals(id)).toList();

        return !response.isEmpty() ? response.get(0) : null;
    }

    public PessoaModel update (PessoaModel modelUpdated, Long id){

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
            return id;
        }

        return null;
    }
}
