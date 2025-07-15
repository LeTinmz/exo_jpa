package org.example.DAO;
import org.example.Entity.Region;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;
public class RegionDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

    public void insert(Region region) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        em.close();
        System.out.println("région " + region.getName() + " créée");
    }

    public Region get(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Region region = em.find(Region.class, id);
            if (region == null) {
                throw new IllegalArgumentException("yapa " + id);
            }
            return region;
        } finally {
            em.close();
        }
    }


    public List<Region> getAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Region> query = em.createQuery("SELECT r FROM Region r", Region.class);
        List<Region> regions = query.getResultList();

        em.close();
        return regions;
    }

    public void update(Region region) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Region regionToUpdate = em.find(Region.class, region.getId());
        if (regionToUpdate != null) {
            regionToUpdate.setName(region.getName());
            regionToUpdate.setSurface(region.getSurface());
            regionToUpdate.setClimat(region.getClimat());
        }

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Region region = em.find(Region.class, id);
        if (region != null) {
            em.remove(region);
        }
        em.getTransaction().commit();
        em.close();
    }
}