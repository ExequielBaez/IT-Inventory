package com.ecommerce.EcommerceV1.controller;


import com.ecommerce.EcommerceV1.controller.dto.ElementDTO;
import com.ecommerce.EcommerceV1.persistance.entity.ElementEntity;
import com.ecommerce.EcommerceV1.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/element")
@CrossOrigin(value = "http://localhost:4200")
public class ElementController {

    @Autowired
    private ElementService elementService;

    @GetMapping
    public ResponseEntity<?> getAllElements(){

        List<ElementDTO> elementDTOList = elementService.getAllElements();

        return ResponseEntity.status(HttpStatus.OK).body(elementDTOList);
    }

    @GetMapping("{idElement}")
    public ResponseEntity<?> getElementById(@PathVariable String idElement){

        ElementDTO elementDTO = elementService.getElementById(idElement);

        return ResponseEntity.status(HttpStatus.OK).body(elementDTO);
    }

    @PostMapping
    public ResponseEntity<?> createElement(@RequestParam("idElement") String idElement,
                                           @RequestParam("nameElement") String nameElement,
                                           @RequestParam("brand") String brand,
                                           @RequestParam("cpu") String cpu,
                                           @RequestParam("mother") String mother,
                                           @RequestParam("hdd") String hdd,
                                           @RequestParam("memory") String memory,
                                           @RequestParam("so") String so,
                                           @RequestParam("ipNumber") String ipNumber,
                                           @RequestParam("workplace") String workplace,
                                           @RequestParam("antivirus") String antivirus,
                                           //@RequestParam("parte") Boolean parte,
                                           //@RequestParam("ocsInventory") Boolean ocsInventory,
                                           @RequestParam("urlImage") String urlImage,
                                           @RequestParam(value = "image", required = false)MultipartFile multipartFile
                                           //@RequestParam("idUser") String idUser,
                                           // @RequestParam("idCategory") String idCategory
                                           ) throws IOException {

        ElementEntity elementEntity = new ElementEntity();

        elementEntity.setIdElement(idElement);
        elementEntity.setNameElement(nameElement);
        elementEntity.setBrand(brand);
        elementEntity.setCpu(cpu);
        elementEntity.setMother(mother);
        elementEntity.setHdd(hdd);
        elementEntity.setMemory(memory);
        elementEntity.setSo(so);
        elementEntity.setIpNumber(ipNumber);
        elementEntity.setWorkplace(workplace);
        elementEntity.setAntivirus(antivirus);
        //elementEntity.setParte(parte);
        //elementEntity.setOcsInventory(ocsInventory);
        elementEntity.setUrlImage(urlImage);
        //productEntity.setUserEntity(idUser);
        //productEntity.setCategoryEntity();

        ElementDTO elementDTO = elementService.createElement(elementEntity, multipartFile);

        return ResponseEntity.status(HttpStatus.CREATED).body(elementDTO);
    }

    @DeleteMapping("{idElement}")
    public ResponseEntity<?> disableElement(@PathVariable String idElement){

        elementService.disableElement(idElement);

        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

