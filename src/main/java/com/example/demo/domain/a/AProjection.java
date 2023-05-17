package com.example.demo.domain.a;

import com.example.demo.domain.b.BProjection;

import java.util.Set;

public interface AProjection {
    Long getId();
    // AProjection getParent();
    Set<BRelationProjection> getBrelations();

    interface BRelationProjection {
        Long getId();
        BProjection getTarget();
        Integer getOrder();
    }
}
