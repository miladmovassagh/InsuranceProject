package model.service;

import model.entity.ParsianInsuranceEmployeesEntity;
import model.repository.ParsianInsuranceEmployeesRepository;

import java.util.*;

public class ParsianInsuranceEmployeesService {

    private static ParsianInsuranceEmployeesService parsianInsuranceEmployeesService = new ParsianInsuranceEmployeesService();

    public static ParsianInsuranceEmployeesService getInstance() {
        return parsianInsuranceEmployeesService;
    }

    private ParsianInsuranceEmployeesService() {

    }

    public void save(ParsianInsuranceEmployeesEntity parsianInsuranceEmployeesEntity) throws Exception {
        try(ParsianInsuranceEmployeesRepository parsianInsuranceEmployeesRepository = new ParsianInsuranceEmployeesRepository()) {
            parsianInsuranceEmployeesRepository.insert(parsianInsuranceEmployeesEntity);
            parsianInsuranceEmployeesRepository.commit();
        }
    }

    public List<ParsianInsuranceEmployeesEntity> report() throws Exception {
        List<ParsianInsuranceEmployeesEntity> parsianInsuranceEmployeesEntities;
        try(ParsianInsuranceEmployeesRepository parsianInsuranceEmployeesRepository = new ParsianInsuranceEmployeesRepository()) {
            parsianInsuranceEmployeesEntities = parsianInsuranceEmployeesRepository.select();
        }
        return parsianInsuranceEmployeesEntities;
    }
}
