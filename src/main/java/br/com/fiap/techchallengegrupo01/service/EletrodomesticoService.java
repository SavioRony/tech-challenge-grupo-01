package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.EletrodomesticoMapper;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.repository.EletrodomesticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    public final EletrodomesticoRepository repository;
    public final EletrodomesticoMapper mapper;

    public EletrodomesticoModel save(EletrodomesticoRequestDTO dto){

        return repository.save(mapper.toModel(dto));
    }

    public EletrodomesticoModel getById(Long id){

        return repository.findById(id).orElse(null);
    }

    public Set<EletrodomesticoModel> getAll(){
       return new HashSet<>(repository.findAll());
    }

    public EletrodomesticoModel update (EletrodomesticoRequestDTO dtoUpdated, Long id){

        var modelById = getById(id);

        if(modelById != null){
            var modelToBeUpdated = mapper.toModel(dtoUpdated);
            modelToBeUpdated.setId(id);
            return repository.save(modelToBeUpdated);
        }

        return null;
    }

    public Long delete(Long id){

        var modelById = getById(id);
        if (modelById != null){
            repository.delete(modelById);
            return id;
        }
        return null;
    }
}
