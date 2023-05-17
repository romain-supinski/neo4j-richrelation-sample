package com.example.demo.domain.c;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRepository  extends Neo4jRepository<CEntity, Long> {
}
