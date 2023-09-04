package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.ConsumoRequestDTO;
import br.com.fiap.techchallengegrupo01.dto.ConsumoRequestEletrodomesticoDTO;
import br.com.fiap.techchallengegrupo01.model.ConsumoModel;
import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.repository.ConsumoRepository;
import br.com.fiap.techchallengegrupo01.repository.EletrodomesticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumoService {


    @Autowired
    private ConsumoRepository repository;

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    public Boolean saveConsumoEletrodomestico(ConsumoRequestDTO requestDTO) {
        EletrodomesticoModel eletrodomesticoModel = eletrodomesticoRepository.getReferenceById(requestDTO.getIdEletrodomestico());

        if (eletrodomesticoModel != null) {
            ConsumoModel consumoModel = new ConsumoModel();
            consumoModel.setEletrodomestico(eletrodomesticoModel);
            consumoModel.setHorasConsumo(requestDTO.getHorasConsumo());
            consumoModel.setData(requestDTO.getData());
            repository.save(consumoModel);
            return true;
        }
        return false;
    }

    public List<ConsumoModel> findConsumo(Long idEletrodomestico) {
        return repository.findByEletrodomestico(idEletrodomestico).orElse(null);
    }
}
