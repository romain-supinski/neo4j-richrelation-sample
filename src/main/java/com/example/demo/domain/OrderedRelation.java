package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RelationshipProperties
public class OrderedRelation<T> implements Comparable<OrderedRelation<T>> {
    @RelationshipId
    @GeneratedValue
    private Long id;
    @TargetNode
    private T target;
    @Property
    private Integer order;

    @Override
    public int compareTo(final OrderedRelation<T> o) {
        return order - o.order;
    }
}
