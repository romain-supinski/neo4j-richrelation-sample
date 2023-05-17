package com.example.demo.domain.a;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AConverter {
    AEntity convert(final AProjection projection);
}
