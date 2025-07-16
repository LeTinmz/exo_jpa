package org.example.Services;

import org.example.DAO.RegionDAO;
import org.example.DAO.SpecieDAO;
import org.example.Entity.Region;
import org.example.Entity.Specie;

import java.util.List;

public class SpecieService {

    private SpecieDAO specieDAO;

    public SpecieService(){
        this.specieDAO = new SpecieDAO();
    }

    public Specie save(Specie specie) {
        return specieDAO.insert(specie);
    }

    public List<Specie> findAll() {
        return specieDAO.getAll();
    }


    public Specie findById(Long id) {
        return specieDAO.get(id);
    }


    public Specie update(Specie specie) {
        return specieDAO.update(specie);
    }

    public void deleteById(Long id) {
        specieDAO.delete(id);
    }
}
