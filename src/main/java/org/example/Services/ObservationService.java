package org.example.Services;

import org.example.DAO.ObservationDAO;
import org.example.Entity.Observation;

import java.util.List;

public class ObservationService {

    private ObservationDAO observationDAO;

    public ObservationService(){
        this.observationDAO = new ObservationDAO();
    }

    public Observation save(Observation observation) {
        return observationDAO.insert(observation);
    }

    public List<Observation> findAll() {
        return observationDAO.getAll();
    }


    public Observation findById(Long id) {
        return observationDAO.get(id);
    }


    public Observation update(Observation observation) {
        return observationDAO.update(observation);
    }

    public void deleteById(Long id) {
        observationDAO.delete(id);
    }

}
