package com.example.demo.domain.b;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BConverter {
    BEntity convert(final BProjection projection);
}
