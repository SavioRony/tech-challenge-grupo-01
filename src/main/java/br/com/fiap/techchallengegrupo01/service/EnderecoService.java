package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.EnderecoMapper;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public EnderecoModel saveEndereco(EnderecoRequestDTO requestDTO) {

        return  repository.save(mapper.toModel(requestDTO));
    }

    public Set<EnderecoModel> getAll(){

        return repository.getAll();
    }

    public EnderecoModel getAll(Long id){

        return repository.getById(id);
    }
}
