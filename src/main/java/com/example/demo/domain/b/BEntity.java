package com.example.demo.domain.b;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.SortedSet;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Node("B")
@EqualsAndHashCode(of = { "id" })
public class BEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship("HasC")
    private SortedSet<CRelation> crelation;
}