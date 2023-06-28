package com.mycompany.group234.repository;


import com.mycompany.group234.model.MediaPlanAndBuying;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class MediaPlanAndBuyingRepository extends SimpleJpaRepository<MediaPlanAndBuying, String> {
    private final EntityManager em;
    public MediaPlanAndBuyingRepository(EntityManager em) {
        super(MediaPlanAndBuying.class, em);
        this.em = em;
    }
    @Override
    public List<MediaPlanAndBuying> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"MediaPlanAndBuying\"", MediaPlanAndBuying.class).getResultList();
    }
}