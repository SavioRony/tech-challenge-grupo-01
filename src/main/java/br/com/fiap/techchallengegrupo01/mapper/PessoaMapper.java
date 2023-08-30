package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.PessoaRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.PessoaRequestUpdateDTO;
import br.com.fiap.techchallengegrupo01.dto.PessoaResponseDTO;
import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaModel toModel(PessoaRequestDTO pessoaRequestDTO);
    PessoaModel toModelUpdate(PessoaRequestUpdateDTO pessoaRequestDTO);
    PessoaResponseDTO toResponseDto(PessoaModel pessoaModel);
    Set<PessoaResponseDTO> toResponseDtoAll(Set<PessoaModel> pessoas);
}
