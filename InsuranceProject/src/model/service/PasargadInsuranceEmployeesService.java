package model.service;

import model.entity.PasargadInsuranceEmployeesEntity;
import model.repository.PasargadInsuranceEmployeesRepository;

import java.util.*;

public class PasargadInsuranceEmployeesService {

    private static PasargadInsuranceEmployeesService pasargadInsuranceEmployeesService = new PasargadInsuranceEmployeesService();

    public static PasargadInsuranceEmployeesService getInstance() {
        return pasargadInsuranceEmployeesService;
    }

    private PasargadInsuranceEmployeesService() {

    }

    public void save(PasargadInsuranceEmployeesEntity pasargadInsuranceEmployeesEntity) throws Exception {
        try(PasargadInsuranceEmployeesRepository pasargadInsuranceEmployeesRepository = new PasargadInsuranceEmployeesRepository()) {
            pasargadInsuranceEmployeesRepository.insert(pasargadInsuranceEmployeesEntity);
            pasargadInsuranceEmployeesRepository.commit();
        }
    }

    public List<PasargadInsuranceEmployeesEntity> report() throws Exception {
        List<PasargadInsuranceEmployeesEntity> pasargadInsuranceEmployeesEntities;
        try(PasargadInsuranceEmployeesRepository pasargadInsuranceEmployeesRepository = new PasargadInsuranceEmployeesRepository()) {
            pasargadInsuranceEmployeesEntities = pasargadInsuranceEmployeesRepository.select();
        }
        return pasargadInsuranceEmployeesEntities;
    }
}
