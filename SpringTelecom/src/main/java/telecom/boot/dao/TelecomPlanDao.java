package telecom.boot.dao;

import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import telecom.boot.model.TelecomPlan;
import java.util.List;

@Repository
@Transactional
public class TelecomPlanDao  {
	@PersistenceContext
    private EntityManager entityManager;

    public List<TelecomPlan> getAllPlans() {
        return entityManager.createQuery("SELECT t FROM TelecomPlan t", TelecomPlan.class).getResultList();
    }

    public TelecomPlan getPlanById(Long id) {
        return entityManager.find(TelecomPlan.class, id);
    }

    public TelecomPlan createPlan(TelecomPlan plan) {
        entityManager.persist(plan);
        return plan;
    }

    public TelecomPlan updatePlan(TelecomPlan plan) {
        return entityManager.merge(plan);
    }

    public void deletePlan(TelecomPlan plan) {
        entityManager.remove(plan);
    }

}
