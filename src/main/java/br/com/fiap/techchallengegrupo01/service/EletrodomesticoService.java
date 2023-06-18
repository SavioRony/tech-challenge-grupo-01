package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.EletrodomesticoMapper;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.repository.EletrodomesticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    public final EletrodomesticoRepository repository;
    public final EletrodomesticoMapper mapper;

    public EletrodomesticoModel save(EletrodomesticoRequestDTO dto){

        return repository.save(mapper.toModel(dto));
    }

    public EletrodomesticoModel getById(Long id){

        return repository.getById(id);
    }

    public Set<EletrodomesticoModel> getAll(){

        return repository.getAll();
    }

    public EletrodomesticoModel update (EletrodomesticoRequestDTO dtoUpdated, Long id){

        return repository.update(mapper.toModel(dtoUpdated),id);
    }

    public Long delete(Long id){
        return repository.delete(id);
    }
}
