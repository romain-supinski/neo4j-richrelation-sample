package com.example.demo.domain.c;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Node("C")
@EqualsAndHashCode(of = { "id" })
public class CEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;
}