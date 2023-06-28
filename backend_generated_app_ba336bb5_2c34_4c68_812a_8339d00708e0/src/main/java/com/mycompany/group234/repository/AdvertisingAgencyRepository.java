package com.mycompany.group234.repository;


import com.mycompany.group234.model.AdvertisingAgency;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class AdvertisingAgencyRepository extends SimpleJpaRepository<AdvertisingAgency, String> {
    private final EntityManager em;
    public AdvertisingAgencyRepository(EntityManager em) {
        super(AdvertisingAgency.class, em);
        this.em = em;
    }
    @Override
    public List<AdvertisingAgency> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"AdvertisingAgency\"", AdvertisingAgency.class).getResultList();
    }
}