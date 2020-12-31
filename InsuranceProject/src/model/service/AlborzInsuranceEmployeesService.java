package model.service;

import model.entity.AlborzInsuranceEmployeesEntity;
import model.repository.AlborzInsuranceEmployeesRepository;

import java.util.*;

public class AlborzInsuranceEmployeesService {

    private static AlborzInsuranceEmployeesService alborzInsuranceEmployeesService = new AlborzInsuranceEmployeesService();

    public static AlborzInsuranceEmployeesService getInstance() {
        return alborzInsuranceEmployeesService;
    }

    private AlborzInsuranceEmployeesService() {

    }

    public void save(AlborzInsuranceEmployeesEntity alborzInsuranceEmployeesEntity) throws Exception {
        try(AlborzInsuranceEmployeesRepository alborzInsuranceEmployeesRepository = new AlborzInsuranceEmployeesRepository()) {
            alborzInsuranceEmployeesRepository.insert(alborzInsuranceEmployeesEntity);
            alborzInsuranceEmployeesRepository.commit();
        }
    }

    public List<AlborzInsuranceEmployeesEntity> report() throws Exception {
        List<AlborzInsuranceEmployeesEntity> alborzInsuranceEmployeesEntities;
        try(AlborzInsuranceEmployeesRepository alborzInsuranceEmployeesRepository = new AlborzInsuranceEmployeesRepository()) {
            alborzInsuranceEmployeesEntities = alborzInsuranceEmployeesRepository.select();
        }
        return alborzInsuranceEmployeesEntities;
    }
}
