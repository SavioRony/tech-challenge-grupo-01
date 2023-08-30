package br.com.fiap.techchallengegrupo01.mapper;

import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.EletrodomesticoResponseDto;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface EletrodomesticoMapper {

    EletrodomesticoModel toModel(EletrodomesticoRequestDTO dto);
    EletrodomesticoResponseDto toResponseDto(EletrodomesticoModel model);
    Set<EletrodomesticoResponseDto> toResponseDtoAll(Set<EletrodomesticoModel> model);
}
