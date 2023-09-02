package br.com.fiap.techchallengegrupo01.repository.specification;

import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoSpecification {

    public EnderecoSpecification() {
        super();
    }

    public static Specification<EnderecoModel> getFilter(String _q) {
        return new Specification<>() {
            @Override
            public Predicate toPredicate(Root<EnderecoModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if (_q == null) {
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }

                String[] filters = _q.split(",");

                for (String filter : filters) {

                    String[] keyValue = filter.split(":");


                    if (keyValue[0].equals("estado")) {

                        Predicate pEstado = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pEstado));

                    } else if (keyValue[0].equals("rua")) {

                        Predicate pRua = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pRua));

                    } else if (keyValue[0].equals("cidade")) {

                        Predicate pCidade = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pCidade));

                    } else if (keyValue[0].equals("bairro")) {

                        Predicate pBairro = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pBairro));

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
