package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.EnderecoRequestDTO;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoModel toModel(EnderecoRequestDTO enderecoRequestDTO);
}
