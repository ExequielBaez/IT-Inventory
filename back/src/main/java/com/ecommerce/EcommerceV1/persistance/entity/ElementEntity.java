package com.ecommerce.EcommerceV1.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
public class ElementEntity {

    @Id
    @UuidGenerator
    private String idElement;

    private String nameElement;

    private String brand;

    private String cpu;

    private String mother;

    private String hdd;

    private String memory;

    private String so;

    private String ipNumber;

    private String workplace;

    private String antivirus;

    private Boolean parte;

    private Boolean ocsInventory;

    private String urlImage;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private CategoryEntity categoryEntity;

    private boolean enabled = true;

}
