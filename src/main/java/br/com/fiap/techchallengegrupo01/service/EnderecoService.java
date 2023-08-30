package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.EnderecoMapper;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.model.UsuarioModel;
import br.com.fiap.techchallengegrupo01.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        return new HashSet<>(repository.findAll());
    }

    public EnderecoModel getById(Long id){
       return repository.findById(id).orElse(null);
    }
    public EnderecoModel getByIdAndIdUsuario(Long idEndereco, UsuarioModel usuario){
        return repository.findByIdAndUsuario(idEndereco, usuario);
    }

    public  EnderecoModel update(EnderecoRequestDTO dto, Long id){

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
