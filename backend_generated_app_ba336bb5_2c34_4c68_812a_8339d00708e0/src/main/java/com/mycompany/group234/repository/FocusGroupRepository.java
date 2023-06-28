package com.mycompany.group234.repository;


import com.mycompany.group234.model.FocusGroup;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class FocusGroupRepository extends SimpleJpaRepository<FocusGroup, String> {
    private final EntityManager em;
    public FocusGroupRepository(EntityManager em) {
        super(FocusGroup.class, em);
        this.em = em;
    }
    @Override
    public List<FocusGroup> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"FocusGroup\"", FocusGroup.class).getResultList();
    }
}