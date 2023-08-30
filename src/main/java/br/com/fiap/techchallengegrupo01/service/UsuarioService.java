package br.com.fiap.techchallengegrupo01.service;

import br.com.fiap.techchallengegrupo01.dto.UsuarioRequestDTO;
import br.com.fiap.techchallengegrupo01.mapper.UsuarioMapper;
import br.com.fiap.techchallengegrupo01.model.UsuarioModel;
import br.com.fiap.techchallengegrupo01.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    private final UsuarioMapper mapper;

    public UsuarioModel save(UsuarioRequestDTO requestDTO) {

        return repository.save(mapper.toModel(requestDTO));
    }

    public Set<UsuarioModel> getAll() {

        return new HashSet<>(repository.findAll());
    }

    public UsuarioModel getById(Long id) {

        return repository.findById(id).orElse(null);
    }

    public UsuarioModel update(UsuarioRequestDTO dto, Long id) {

        var modelById = getById(id);

        if (modelById != null) {
            var modelToBeUpdated = mapper.toModel(dto);
            modelToBeUpdated.setId(id);
            return repository.save(modelToBeUpdated);
        }

        return null;
    }

    public Long delete(Long id) {

        var modelById = getById(id);

        if (modelById != null) {

            repository.delete(modelById);
            return id;

        }
        return null;
    }
}
