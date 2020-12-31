package model.service;

import model.entity.IranInsuranceEmployeesEntity;
import model.repository.IranInsuranceEmployeesRepository;

import java.util.*;

public class IranInsuranceEmployeesService {

    private static IranInsuranceEmployeesService iranInsuranceEmployeesService = new IranInsuranceEmployeesService();

    public static IranInsuranceEmployeesService getInstance() {
        return iranInsuranceEmployeesService;
    }

    private IranInsuranceEmployeesService() {

    }

    public void save(IranInsuranceEmployeesEntity iranInsuranceEmployeesEntity) throws Exception {
        try(IranInsuranceEmployeesRepository iranInsuranceEmployeesRepository = new IranInsuranceEmployeesRepository()) {
            iranInsuranceEmployeesRepository.insert(iranInsuranceEmployeesEntity);
            iranInsuranceEmployeesRepository.commit();
        }
    }

    public List<IranInsuranceEmployeesEntity> report() throws Exception {
        List<IranInsuranceEmployeesEntity> iranInsuranceEmployeesEntities;
        try(IranInsuranceEmployeesRepository iranInsuranceEmployeesRepository = new IranInsuranceEmployeesRepository()) {
            iranInsuranceEmployeesEntities = iranInsuranceEmployeesRepository.select();
        }
        return iranInsuranceEmployeesEntities;
    }
}
