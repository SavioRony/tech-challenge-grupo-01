package br.com.fiap.techchallengegrupo01.repository.specification;

import br.com.fiap.techchallengegrupo01.model.EletrodomesticoModel;
import br.com.fiap.techchallengegrupo01.model.EnderecoModel;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EletrodomesticoSpecification {

    public EletrodomesticoSpecification(){
        super();
    }

    public static Specification<EletrodomesticoModel> getFilter(String _q){
        return new Specification<>() {
            @Override
            public Predicate toPredicate(Root<EletrodomesticoModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if (_q == null) {
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }

                String[] filters = _q.split(",");

                for (String filter : filters) {
                    String[] keyValue = filter.split(":");

                    if (keyValue[0].equals("marca")) {

                        Predicate pMarca = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pMarca));

                    } else if (keyValue[0].equals("tipo")) {

                        Predicate pTipo = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pTipo));

                    } else if (keyValue[0].equals("modelo")) {

                        Predicate pModelo = criteriaBuilder.like(criteriaBuilder.upper(root.get(keyValue[0])), keyValue[1].toUpperCase());
                        predicates.add(criteriaBuilder.and(pModelo));

                    } else if (keyValue[0].equals("userId")) {

                        Join<EletrodomesticoModel, EnderecoModel> join = root.join("endereco", JoinType.LEFT);
                        Predicate pUser = criteriaBuilder.equal(join.get("usuario").get("id"), keyValue[1]);
                        predicates.add(criteriaBuilder.and(pUser));

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
