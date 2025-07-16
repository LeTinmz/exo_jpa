package org.example.DAO;

import org.example.Entity.Observation;
import org.example.Entity.Region;
import org.example.utils.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObservationDAO {
    private final EntityManager em;

    public ObservationDAO() {
        this.em = DatabaseManager.getEntityManager();
    }

    public void insert(Observation observation) {

        em.getTransaction().begin();
        em.persist(observation);
        em.getTransaction().commit();
        em.close();
        System.out.println("observation de " + observation.getObserverName() + " créée");
    }

    public Observation get(Long id) {

        try {
            Observation observation = em.find(Observation.class, id);
            if (observation == null) {
                throw new IllegalArgumentException("yapa " + id);
            }
            return observation;
        } finally {
            em.close();
        }
    }


    public List<Observation> getAll() {


        TypedQuery<Observation> query = em.createQuery("SELECT o FROM Observation o", Observation.class);
        List<Observation> observations = query.getResultList();

        em.close();
        return observations;
    }

    public void update(Observation observation) {

        em.getTransaction().begin();

        Observation observationToUpdate = em.find(Observation.class, observation.getId());
        if (observationToUpdate != null) {
            observationToUpdate.setObserverName(observation.getObserverName());
            observationToUpdate.setLocation(observation.getLocation());
            observationToUpdate.setLatitude(observation.getLatitude());
            observationToUpdate.setLongitude(observation.getLongitude());
            observationToUpdate.setObservationDate(observation.getObservationDate());
        }

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {

        em.getTransaction().begin();
        Observation observation = em.find(Observation.class, id);
        if (observation != null) {
            em.remove(observation);
        }
        em.getTransaction().commit();
        em.close();
    }
}
