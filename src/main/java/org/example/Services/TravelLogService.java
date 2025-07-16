package org.example.Services;

import org.example.DAO.SpecieDAO;
import org.example.DAO.TravelLogDAO;
import org.example.Entity.Specie;
import org.example.Entity.TravelLog;

import java.util.List;

public class TravelLogService {

    private TravelLogDAO travelLogDAO;

    public TravelLogService(){
        this.travelLogDAO = new TravelLogDAO();
    }

    public TravelLog save(TravelLog travelLog) {
        return travelLogDAO.insert(travelLog);
    }

    public List<TravelLog> findAll() {
        return travelLogDAO.getAll();
    }


    public TravelLog findById(Long id) {
        return travelLogDAO.get(id);
    }


    public TravelLog update(TravelLog travelLog) {
        return travelLogDAO.update(travelLog);
    }

    public void deleteById(Long id) {
        travelLogDAO.delete(id);
    }
}
