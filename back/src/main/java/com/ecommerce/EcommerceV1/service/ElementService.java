package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.controller.dto.ElementDTO;
import com.ecommerce.EcommerceV1.persistance.entity.ElementEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ElementService {
    List<ElementDTO> getAllElements();

    ElementDTO getElementById(String idElement);

    ElementDTO createElement(ElementEntity elementEntity, MultipartFile multipartFile) throws IOException;

    void disableElement(String idElement);
}
