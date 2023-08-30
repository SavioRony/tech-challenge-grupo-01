package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestUpdateDTO;
import br.com.fiap.techchallengegrupo01.dto.EnderecoResponseDTO;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoModel toModel(EnderecoRequestDTO enderecoRequestDTO);
    EnderecoModel toModel(EnderecoRequestUpdateDTO enderecoRequestDTO);
    EnderecoResponseDTO toResponseDto(EnderecoModel enderecoModel);
    Set<EnderecoResponseDTO> toResponseDtoAll(Set<EnderecoModel> enderecoModels);
}
