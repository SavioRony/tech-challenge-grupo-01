package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.PessoaMapper;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import br.com.fiap.techchallengegrupo01.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    private final PessoaMapper mapper;

    public Boolean savePessoa(PessoaRequestDTO requestDTO) {
        PessoaModel pessoaModel = mapper.toModel(requestDTO);
        if (pessoaModel != null) {
            repository.save(pessoaModel);
            return true;
        }
        return false;
    }
}
