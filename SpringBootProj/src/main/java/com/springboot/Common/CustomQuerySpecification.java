package com.springboot.Common;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class CustomQuerySpecification<T> implements Specification<T> {

    private Map<String, Object> filters;

    // Private constructor
    private CustomQuerySpecification(Map<String, Object> filters) {
        this.filters = filters;
    }

    // Factory method
    public static <T> CustomQuerySpecification<T> getInstance(Map<String, Object> filters) {
        return new CustomQuerySpecification<>(filters);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Predicate predicate = cb.conjunction();

        for (Map.Entry<String, Object> entry : filters.entrySet()) {

            String key = entry.getKey();
            Object value = entry.getValue();

            if (value == null) continue;

            if (value instanceof String) {
                predicate = cb.and(predicate,
                        cb.like(cb.lower(root.get(key)),
                                "%" + value.toString().toLowerCase() + "%"));
            } else {
                predicate = cb.and(predicate,
                        cb.equal(root.get(key), value));
            }
        }

        return predicate;
    }
}