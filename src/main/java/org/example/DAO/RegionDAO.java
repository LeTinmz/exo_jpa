package org.example.DAO;
import org.example.Entity.Region;
import org.example.utils.DatabaseManager;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;
public class RegionDAO {
    private final EntityManager em;

    public RegionDAO() {
        this.em = DatabaseManager.getEntityManager();
    }

    public void insert(Region region) {

        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        em.close();
        System.out.println("région " + region.getName() + " créée");
    }

    public Region get(Long id) {

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


        TypedQuery<Region> query = em.createQuery("SELECT r FROM Region r", Region.class);
        List<Region> regions = query.getResultList();

        em.close();
        return regions;
    }

    public void update(Region region) {

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

        em.getTransaction().begin();
        Region region = em.find(Region.class, id);
        if (region != null) {
            em.remove(region);
        }
        em.getTransaction().commit();
        em.close();
    }
}