package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.exception.BadRequestException;
import br.com.fiap.techchallengegrupo01.mapper.EletrodomesticoMapper;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.repository.EletrodomesticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    private final EletrodomesticoRepository repository;
    private final EletrodomesticoMapper mapper;
    private final EnderecoService enderecoService;

    public EletrodomesticoModel save(EletrodomesticoRequestDTO requestDTO){
        EnderecoModel endereco = enderecoService.getById(requestDTO.getIdEndereco());
        if(endereco == null){
            throw new BadRequestException("Endereço não encontrado");
        }
        EletrodomesticoModel eletrodomestico = mapper.toModel(requestDTO);
        eletrodomestico.setEndereco(endereco);
        return repository.save(eletrodomestico);
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
            EnderecoModel endereco = enderecoService.getById(dtoUpdated.getIdEndereco());
            if(endereco == null){
                throw new BadRequestException("Endereço não encontrado");
            }
            var modelToBeUpdated = mapper.toModel(dtoUpdated);
            modelToBeUpdated.setId(id);
            modelToBeUpdated.setEndereco(endereco);
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
