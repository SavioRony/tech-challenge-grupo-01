package br.com.fiap.techchallengegrupo01.repository;

import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> , JpaSpecificationExecutor<PessoaModel> {}
