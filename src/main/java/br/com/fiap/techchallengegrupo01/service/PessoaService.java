package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.PessoaRequestUpdateDTO;
import br.com.fiap.techchallengegrupo01.exception.BadRequestException;
import br.com.fiap.techchallengegrupo01.mapper.PessoaMapper;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import br.com.fiap.techchallengegrupo01.model.UsuarioModel;
import br.com.fiap.techchallengegrupo01.repository.PessoaRepository;
import br.com.fiap.techchallengegrupo01.repository.specification.PessoaSpecification;
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

    private final EnderecoService enderecoService;

    private final UsuarioService usuarioService;

    public PessoaModel savePessoa(PessoaRequestDTO requestDTO) {
        UsuarioModel usuario = usuarioService.getById(requestDTO.getIdUsuario());
        if(usuario == null){
            throw new BadRequestException("Usuario não encontrado");
        }
        EnderecoModel endereco = enderecoService.getByIdAndIdUsuario(requestDTO.getIdEndereco(), usuario);
        if(endereco == null){
            throw new BadRequestException("Endereço não encontrado");
        }
        PessoaModel pessoa = mapper.toModel(requestDTO);
        pessoa.setEndereco(endereco);
        pessoa.setUsuario(usuario);
        return repository.save(pessoa);
    }

    public Set<PessoaModel> getAll(String _q){

        return new HashSet<>(repository.findAll(PessoaSpecification.getFilter(_q)));
    }

    public PessoaModel getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public PessoaModel update(PessoaRequestUpdateDTO requestDTO, Long id){

        var pessoa = getById(id);
        if(pessoa != null){
            EnderecoModel endereco = enderecoService.getByIdAndIdUsuario(requestDTO.getIdEndereco(), pessoa.getUsuario());
            if(endereco == null){
                throw new BadRequestException("Endereço não encontrado");
            }
            var pessoaModel = mapper.toModelUpdate(requestDTO);
            pessoaModel.setId(id);
            pessoaModel.setUsuario(pessoa.getUsuario());
            pessoaModel.setEndereco(endereco);
            return repository.save(pessoaModel);
        }

        return null;
    }

    public Long delete(Long id){

        var pessoa = getById(id);
        if(pessoa != null){
            repository.deleteById(pessoa.getId());
            return id;
        }
        return null;
    }

}
