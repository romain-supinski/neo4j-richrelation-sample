package com.example.demo.domain.b;

import com.example.demo.domain.c.CProjection;

import java.util.Set;

public interface BProjection {
    Long getId();
    Set<CRelationProjection> getCrelation();

    interface CRelationProjection {
        Long getId();
        CProjection getTarget();
        Integer getOrder();
    }
}
