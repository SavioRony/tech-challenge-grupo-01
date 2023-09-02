package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestUpdateDTO;
import br.com.fiap.techchallengegrupo01.exception.BadRequestException;
import br.com.fiap.techchallengegrupo01.mapper.EnderecoMapper;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.model.UsuarioModel;
import br.com.fiap.techchallengegrupo01.repository.EnderecoRepository;
import br.com.fiap.techchallengegrupo01.repository.specification.EnderecoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;
    private final UsuarioService usuarioService;


    public EnderecoModel saveEndereco(EnderecoRequestDTO requestDTO) {
        UsuarioModel usuario = usuarioService.getById(requestDTO.getIdUsuario());
        if(usuario == null){
            throw new BadRequestException("Usuario não encontrado");
        }
        EnderecoModel endereco = mapper.toModel(requestDTO);
        endereco.setUsuario(usuario);
        return repository.save(endereco);
    }

    public Set<EnderecoModel> getAll(String _q){
        return new HashSet<>(repository.findAll(EnderecoSpecification.getFilter(_q)));
    }

    public EnderecoModel getById(Long id){
       return repository.findById(id).orElse(null);
    }
    public EnderecoModel getByIdAndIdUsuario(Long idEndereco, UsuarioModel usuario){
        return repository.findByIdAndUsuario(idEndereco, usuario);
    }

    public  EnderecoModel update(EnderecoRequestUpdateDTO dto, Long id){
        var endereco = getById(id);

        if(endereco != null){
            var enderecoUpdate = mapper.toModel(dto);
            enderecoUpdate.setId(id);
            enderecoUpdate.setUsuario(endereco.getUsuario());
            return repository.save(enderecoUpdate);
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
