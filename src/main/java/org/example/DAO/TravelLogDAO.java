package org.example.DAO;

import org.example.Entity.Observation;
import org.example.Entity.Specie;
import org.example.Entity.TravelLog;
import org.example.utils.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TravelLogDAO {
    private final EntityManager em;

    public TravelLogDAO() {
        this.em = DatabaseManager.getEntityManager();
    }

    public void insert(TravelLog travelLog) {

        em.getTransaction().begin();
        em.persist(travelLog);
        em.getTransaction().commit();
        em.close();
        System.out.println("TravelLog " + travelLog.getId() + " créé");
    }

    public TravelLog get(Long id) {

        try {
            TravelLog travelLog = em.find(TravelLog.class, id);
            if (travelLog == null) {
                throw new IllegalArgumentException("yapa " + id);
            }
            return travelLog;
        } finally {
            em.close();
        }
    }


    public List<TravelLog> getAll() {


        TypedQuery<TravelLog> query = em.createQuery("SELECT t FROM TravelLog t", TravelLog.class);
        List<TravelLog> travelLogs = query.getResultList();

        em.close();
        return travelLogs;
    }

    public void update(TravelLog travelLog) {

        em.getTransaction().begin();

        TravelLog travelLogToUpdate = em.find(TravelLog.class, travelLog.getId());
        if (travelLogToUpdate != null) {
            travelLogToUpdate.setDistanceKm(travelLog.getDistanceKm());
            travelLogToUpdate.setTravelMode(travelLog.getTravelMode());
            travelLogToUpdate.setObservation(travelLog.getObservation());
        }

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {

        em.getTransaction().begin();
        TravelLog travelLog = em.find(TravelLog.class, id);
        if (travelLog != null) {
            em.remove(travelLog);
        }
        em.getTransaction().commit();
        em.close();
    }
}
