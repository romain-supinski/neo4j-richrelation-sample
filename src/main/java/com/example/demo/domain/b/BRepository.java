package com.example.demo.domain.b;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BRepository extends Neo4jRepository<BEntity, Long> {
    Optional<BProjection> findOneById(Long id);
}
