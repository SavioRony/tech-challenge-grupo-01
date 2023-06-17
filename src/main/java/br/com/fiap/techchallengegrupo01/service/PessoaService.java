package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.PessoaMapper;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import br.com.fiap.techchallengegrupo01.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return repository.getAll();
    }

    public PessoaModel getById(Long id){

        return repository.getById(id);
    }
}
