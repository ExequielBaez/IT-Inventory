package com.ecommerce.EcommerceV1.persistance.mappers;

import com.ecommerce.EcommerceV1.controller.dto.ElementDTO;
import com.ecommerce.EcommerceV1.persistance.entity.ElementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElementMapper {
    @Mappings(
            {
                    @Mapping(source = "idElement", target = "idElement"),
                    @Mapping(source = "nameElement", target = "nameElement"),
                    @Mapping(source = "cpu", target = "cpu"),
                    @Mapping(source = "brand", target = "brand"),
                    @Mapping(source = "mother", target = "mother"),
                    @Mapping(source = "hdd", target = "hdd"),
                    @Mapping(source = "memory", target = "memory"),
                    @Mapping(source = "so", target = "so"),
                    @Mapping(source = "ipNumber", target = "ipNumber"),
                    @Mapping(source = "workplace", target = "workplace"),
                    @Mapping(source = "antivirus", target = "antivirus"),
                    @Mapping(source = "parte", target = "parte"),
                    @Mapping(source = "ocsInventory", target = "ocsInventory"),
                    @Mapping(source = "urlImage", target = "urlImage"),
                    @Mapping(source = "userEntity.idUser", target = "idUser"),
                    @Mapping(source = "categoryEntity.idCategory", target = "idCategory")
            }
    )
    ElementDTO toElementDto(ElementEntity elementEntity);
    List<ElementDTO> toElementDTOList(List<ElementEntity> elementEntityIterable);

}
