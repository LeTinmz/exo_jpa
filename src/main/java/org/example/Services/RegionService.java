package org.example.Services;

import org.example.DAO.ObservationDAO;
import org.example.DAO.RegionDAO;
import org.example.Entity.Observation;
import org.example.Entity.Region;

import java.util.List;

public class RegionService {
    private RegionDAO regionDAO;

    public RegionService(){
        this.regionDAO = new RegionDAO();
    }

    public Region save(Region region) {
        return regionDAO.insert(region);
    }

    public List<Region> findAll() {
        return regionDAO.getAll();
    }


    public Region findById(Long id) {
        return regionDAO.get(id);
    }


    public Region update(Region region) {
        return regionDAO.update(region);
    }

    public void deleteById(Long id) {
        regionDAO.delete(id);
    }
}
