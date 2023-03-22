package com.examplemarket.persistence.mapper;

import com.examplemarket.domain.Category;
import com.examplemarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active")
    })
    Category toCategory(Categoria categoria);

    // Hace lo inverso al @Mappings anterior
    // No es necesario volver a escribir un @Mappings
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Category toCategoria(Category category);
}
