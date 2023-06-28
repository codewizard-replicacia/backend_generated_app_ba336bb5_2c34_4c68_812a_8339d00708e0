package com.mycompany.group234.repository;


import com.mycompany.group234.model.BrandPerception;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class BrandPerceptionRepository extends SimpleJpaRepository<BrandPerception, String> {
    private final EntityManager em;
    public BrandPerceptionRepository(EntityManager em) {
        super(BrandPerception.class, em);
        this.em = em;
    }
    @Override
    public List<BrandPerception> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"BrandPerception\"", BrandPerception.class).getResultList();
    }
}