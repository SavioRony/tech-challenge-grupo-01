package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.UsuarioRequestDTO;
import br.com.fiap.techchallengegrupo01.model.UsuarioModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioModel toModel(UsuarioRequestDTO requestDTO);
}
