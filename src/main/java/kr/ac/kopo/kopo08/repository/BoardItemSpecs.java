package kr.ac.kopo.kopo08.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import kr.ac.kopo.kopo08.domain.BoardItem;

public class BoardItemSpecs {
    public static Specification<BoardItem> searchTitle(Map<String, Object> filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            filter.forEach((key, value) -> {
                switch (key) {
                case "title":
                        predicates.add(builder.like(root.get(key).as(String.class), "%" + value + "%"));
                }
            });
            
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
    public static Specification<BoardItem> searchWriter(Map<String, Object> filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            filter.forEach((key, value) -> {
                switch (key) {
                case "writer":
                        predicates.add(builder.like(root.get(key).as(String.class), "%" + value + "%"));
                }
            });
            
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

//    public static Specification<BoardItem> titleLike(final String keyword) {
//        return new Specification<BoardItem>() {
//            @Override
//            public Predicate toPredicate(Root<BoardItem> root,
//                    CriteriaQuery<?> query, CriteriaBuilder cb) {
//                return cb.like(root.get(BoardItem_.title), "%" + keyword + "%");
//
//            }
//
//        };
//
//    }

}
