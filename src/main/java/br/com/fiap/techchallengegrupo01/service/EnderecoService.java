package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.EnderecoMapper;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public Boolean saveEndereco(EnderecoRequestDTO requestDTO) {
        EnderecoModel endereco = mapper.toModel(requestDTO);
        if (endereco != null) {
            return repository.save(endereco) != null;
        }
        return false;
    }
}
