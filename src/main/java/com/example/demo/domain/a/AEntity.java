package com.example.demo.domain.a;

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
@Node("A")
@EqualsAndHashCode(of = { "id" })
public class AEntity {
    @Id
    @GeneratedValue
    private Long id;

//    @Relationship("HasParent")
//    private AEntity parent;

    @Relationship("HasB")
    private SortedSet<BRelation> brelations;
}
