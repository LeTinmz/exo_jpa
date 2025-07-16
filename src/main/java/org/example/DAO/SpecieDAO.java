package org.example.DAO;

import org.example.Entity.Observation;
import org.example.Entity.Specie;
import org.example.utils.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SpecieDAO {
    private final EntityManager em;

    public SpecieDAO() {
        this.em = DatabaseManager.getEntityManager();
    }

    public Specie insert(Specie specie) {

        em.getTransaction().begin();
        em.persist(specie);
        em.getTransaction().commit();
        em.close();
        System.out.println("espèce " + specie.getCommonName() + " créée");
        return specie;
    }

    public Specie get(Long id) {

        try {
          Specie specie = em.find(Specie.class, id);
            if (specie == null) {
                throw new IllegalArgumentException("yapa " + id);
            }
            return specie;
        } finally {
            em.close();
        }
    }


    public List<Specie> getAll() {


        TypedQuery<Specie> query = em.createQuery("SELECT s FROM Specie s", Specie.class);
        List<Specie> species = query.getResultList();

        em.close();
        return species;
    }

    public Specie update(Specie specie) {

        em.getTransaction().begin();

        Specie specieToUpdate = em.find(Specie.class, specie.getId());
        if (specieToUpdate != null) {
            specieToUpdate.setCommonName(specie.getCommonName());
            specieToUpdate.setScientificName(specie.getScientificName());
            specieToUpdate.setCategory(specie.getCategory());
        }

        em.getTransaction().commit();
        em.close();
        return specieToUpdate;
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
