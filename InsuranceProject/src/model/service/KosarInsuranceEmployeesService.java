package model.service;

import model.entity.KosarInsuranceEmployeesEntity;
import model.repository.KosarInsuranceEmployeesRepository;

import java.util.*;

public class KosarInsuranceEmployeesService {

    private static KosarInsuranceEmployeesService kosarInsuranceEmployeesService = new KosarInsuranceEmployeesService();

    public static KosarInsuranceEmployeesService getInstance() {
        return kosarInsuranceEmployeesService;
    }

    private KosarInsuranceEmployeesService() {

    }

    public void save(KosarInsuranceEmployeesEntity kosarInsuranceEmployeesEntity) throws Exception {
        try(KosarInsuranceEmployeesRepository kosarInsuranceEmployeesRepository = new KosarInsuranceEmployeesRepository()) {
            kosarInsuranceEmployeesRepository.insert(kosarInsuranceEmployeesEntity);
            kosarInsuranceEmployeesRepository.commit();
        }
    }

    public List<KosarInsuranceEmployeesEntity> report() throws Exception {
        List<KosarInsuranceEmployeesEntity> kosarInsuranceEmployeesEntities;
        try(KosarInsuranceEmployeesRepository kosarInsuranceEmployeesRepository = new KosarInsuranceEmployeesRepository()) {
            kosarInsuranceEmployeesEntities = kosarInsuranceEmployeesRepository.select();
        }
        return kosarInsuranceEmployeesEntities;
    }
}
