package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.PessoaMapper;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import br.com.fiap.techchallengegrupo01.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    private final PessoaMapper mapper;

    public PessoaModel savePessoa(PessoaRequestDTO requestDTO) {

        return repository.save(mapper.toModel(requestDTO));
    }

    public Set<PessoaModel> getAll(){

        return new HashSet<>(repository.findAll());
    }

    public PessoaModel getById(Long id){

        return repository.findById(id).orElse(null);
    }

    public PessoaModel update(PessoaRequestDTO dto, Long id){

        var modelById = getById(id);

        if(modelById != null){

            var modelToBeUpdated = mapper.toModel(dto);
            modelToBeUpdated.setId(id);
            return repository.save(modelToBeUpdated);
        }

        return null;
    }

    public Long delete(Long id){

        var modelById = getById(id);

        if(modelById != null){

            repository.delete(modelById);
            return id;

        }
        return null;
    }
}
