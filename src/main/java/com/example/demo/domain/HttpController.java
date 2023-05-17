package com.example.demo.domain;

import com.example.demo.domain.a.AEntity;
import com.example.demo.domain.a.AProjection;
import com.example.demo.domain.b.BEntity;
import com.example.demo.domain.b.BProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HttpController {

    @Autowired
    private TestService service;

    @PostMapping
    public ResponseEntity<AEntity> createOne() {
        final AEntity a = service.createOne();
        return ResponseEntity.ok(a);
    }

    @GetMapping("/a/{id}")
    public ResponseEntity<AEntity> getOneA(@PathVariable final Long id) {
        return service.getOneAById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/b/{id}")
    public ResponseEntity<BEntity> getOneB(@PathVariable final Long id) {
        return service.getOneBById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
