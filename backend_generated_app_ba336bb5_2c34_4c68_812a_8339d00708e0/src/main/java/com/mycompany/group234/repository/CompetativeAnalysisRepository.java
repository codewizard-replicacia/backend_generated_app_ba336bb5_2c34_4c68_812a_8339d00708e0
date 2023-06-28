package com.mycompany.group234.repository;


import com.mycompany.group234.model.CompetativeAnalysis;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class CompetativeAnalysisRepository extends SimpleJpaRepository<CompetativeAnalysis, String> {
    private final EntityManager em;
    public CompetativeAnalysisRepository(EntityManager em) {
        super(CompetativeAnalysis.class, em);
        this.em = em;
    }
    @Override
    public List<CompetativeAnalysis> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"CompetativeAnalysis\"", CompetativeAnalysis.class).getResultList();
    }
}