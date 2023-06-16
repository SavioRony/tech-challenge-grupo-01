package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaModel toModel(PessoaRequestDTO pessoaRequestDTO);
}
