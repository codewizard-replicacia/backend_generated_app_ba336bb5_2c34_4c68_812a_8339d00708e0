package com.mycompany.group234.repository;


import com.mycompany.group234.model.Survey;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SurveyRepository extends SimpleJpaRepository<Survey, String> {
    private final EntityManager em;
    public SurveyRepository(EntityManager em) {
        super(Survey.class, em);
        this.em = em;
    }
    @Override
    public List<Survey> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Survey\"", Survey.class).getResultList();
    }
}