package br.com.fiap.techchallengegrupo01.repository.specification;

import br.com.fiap.techchallengegrupo01.model.PessoaModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PessoaSpecification {

    public PessoaSpecification() {
        super();
    }

    public static Specification<PessoaModel> getFilter(String _q) {
        return new Specification<>() {
            @Override
            public Predicate toPredicate(Root<PessoaModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if (_q == null) {
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }

                String[] filters = _q.split(",");

                for (String filter : filters) {
                    String[] keyValue = filter.split(":");


                    if (keyValue[0].equals("nome")) {

                        Predicate pNome = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pNome));

                    } else if (keyValue[0].equals("parentesco")) {

                        Predicate pParentesco = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pParentesco));

                    } else if (keyValue[0].equals("sexo")) {

                        Predicate pSexo = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pSexo));

                    } else if (keyValue[0].equals("userId")) {

                        Predicate pUserId = criteriaBuilder.equal(root.get("usuario").get("id"), keyValue[1]);
                        predicates.add(criteriaBuilder.and(pUserId));

                    } else {

                        Predicate pDefault = criteriaBuilder.equal(root.get(keyValue[0]), keyValue[1]);
                        predicates.add(criteriaBuilder.and(pDefault));

                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
