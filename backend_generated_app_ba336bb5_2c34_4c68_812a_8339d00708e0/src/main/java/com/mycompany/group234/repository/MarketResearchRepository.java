package com.mycompany.group234.repository;


import com.mycompany.group234.model.MarketResearch;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class MarketResearchRepository extends SimpleJpaRepository<MarketResearch, String> {
    private final EntityManager em;
    public MarketResearchRepository(EntityManager em) {
        super(MarketResearch.class, em);
        this.em = em;
    }
    @Override
    public List<MarketResearch> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"MarketResearch\"", MarketResearch.class).getResultList();
    }
}