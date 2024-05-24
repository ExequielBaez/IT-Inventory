package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.controller.dto.ElementDTO;
import com.ecommerce.EcommerceV1.exceptions.RegisterNotFound;
import com.ecommerce.EcommerceV1.persistance.entity.ElementEntity;
import com.ecommerce.EcommerceV1.persistance.mappers.ElementMapper;
import com.ecommerce.EcommerceV1.persistance.repository.ElementRepository;
import com.ecommerce.EcommerceV1.service.ElementService;
import com.ecommerce.EcommerceV1.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
@Slf4j
public class ElementServiceImpl implements ElementService {
    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private ElementMapper elementMapper;
    @Override
    public List<ElementDTO> getAllElements() {
        List<ElementDTO> elementList = elementMapper.toElementDTOList(elementRepository.findAllEnable());
        return elementList;
    }

    @Override
    public ElementDTO getElementById(String idElement) {
        ElementDTO elementDTO = elementMapper.toElementDto(elementRepository.findById(idElement).orElseThrow());

        return elementDTO;
    }

    @Override
    public ElementDTO createElement(ElementEntity elementEntity, MultipartFile multipartFile) throws IOException {

        if(!elementEntity.getIdElement().isEmpty()){//cuando es un producto modificado
            if(multipartFile==null){//imagen anterior
                elementEntity.setUrlImage(elementEntity.getUrlImage());
            }else{//imagen del usuario
                log.info("nombre de la url: {}", elementEntity.getUrlImage());
                String nameFile = elementEntity.getUrlImage().substring(29);
                log.info("nombre de la imagen: {}", nameFile);
                if(!nameFile.equals("no image.jpg")){
                    uploadFileService.delete(nameFile);
                }
                elementEntity.setUrlImage(uploadFileService.upload(multipartFile));
            }
        }else{// producto nuevo

            elementEntity.setUrlImage(uploadFileService.upload(multipartFile));
        }
        return elementMapper.toElementDto(elementRepository.save(elementEntity));
    }

    @Override
    public void disableElement(String idElement) {
        ElementEntity element = elementRepository.findById(idElement)
                .orElseThrow( () -> new RegisterNotFound("User Not Found with id " +idElement));

        element.setEnabled(false);

        String nameFile = element.getUrlImage().substring(29);
        log.info("nombre de la imagen: {}", nameFile);
        if(!nameFile.equals("no image.jpg")){
            uploadFileService.delete(nameFile);
        }

        elementRepository.save(element);
    }
}
