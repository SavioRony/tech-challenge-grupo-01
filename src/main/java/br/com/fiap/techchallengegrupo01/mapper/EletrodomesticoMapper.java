package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EletrodomesticoMapper {

    EletrodomesticoModel toModel(EletrodomesticoRequestDTO dto);
}
