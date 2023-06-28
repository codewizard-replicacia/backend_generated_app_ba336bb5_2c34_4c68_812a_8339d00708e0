package com.mycompany.group234.repository;


import com.mycompany.group234.model.DataAnalysis;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class DataAnalysisRepository extends SimpleJpaRepository<DataAnalysis, String> {
    private final EntityManager em;
    public DataAnalysisRepository(EntityManager em) {
        super(DataAnalysis.class, em);
        this.em = em;
    }
    @Override
    public List<DataAnalysis> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"DataAnalysis\"", DataAnalysis.class).getResultList();
    }
}