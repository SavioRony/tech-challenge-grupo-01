package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import br.com.fiap.techchallengegrupo01.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> , JpaSpecificationExecutor<EnderecoModel> {
    EnderecoModel findByIdAndUsuario(Long id, UsuarioModel idUsuario);
}
