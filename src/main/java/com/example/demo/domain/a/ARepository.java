package com.example.demo.domain.a;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ARepository extends Neo4jRepository<AEntity, Long> {

    Optional<AProjection> findOneById(Long id);
}
