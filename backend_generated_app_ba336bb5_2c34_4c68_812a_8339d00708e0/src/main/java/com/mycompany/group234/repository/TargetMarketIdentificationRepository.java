package com.mycompany.group234.repository;


import com.mycompany.group234.model.TargetMarketIdentification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class TargetMarketIdentificationRepository extends SimpleJpaRepository<TargetMarketIdentification, String> {
    private final EntityManager em;
    public TargetMarketIdentificationRepository(EntityManager em) {
        super(TargetMarketIdentification.class, em);
        this.em = em;
    }
    @Override
    public List<TargetMarketIdentification> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"TargetMarketIdentification\"", TargetMarketIdentification.class).getResultList();
    }
}