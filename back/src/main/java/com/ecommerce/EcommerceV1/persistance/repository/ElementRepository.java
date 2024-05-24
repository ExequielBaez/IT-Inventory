package com.ecommerce.EcommerceV1.persistance.repository;

import com.ecommerce.EcommerceV1.persistance.entity.ElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<ElementEntity, String> {

    @Query(value = "SELECT * FROM element_entity WHERE enabled = true", nativeQuery = true)
    List<ElementEntity> findAllEnable();
}
