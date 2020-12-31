package model.service;

import model.entity.SocialSupplyInsuranceEmployeesEntity;
import model.repository.SocialSupplyInsuranceEmployeesRepository;

import java.util.*;

public class SocialSupplyInsuranceEmployeesService {

    private static SocialSupplyInsuranceEmployeesService socialSupplyInsuranceEmployeesService = new SocialSupplyInsuranceEmployeesService();

    public static SocialSupplyInsuranceEmployeesService getInstance() {
        return socialSupplyInsuranceEmployeesService;
    }

    private SocialSupplyInsuranceEmployeesService() {

    }

    public void save(SocialSupplyInsuranceEmployeesEntity socialSupplyInsuranceEmployeesEntity) throws Exception {
        try(SocialSupplyInsuranceEmployeesRepository socialSupplyInsuranceEmployeesRepository = new SocialSupplyInsuranceEmployeesRepository()) {
            socialSupplyInsuranceEmployeesRepository.insert(socialSupplyInsuranceEmployeesEntity);
            socialSupplyInsuranceEmployeesRepository.commit();
        }
    }

    public List<SocialSupplyInsuranceEmployeesEntity> report() throws Exception {
        List<SocialSupplyInsuranceEmployeesEntity> socialSupplyInsuranceEmployeesEntities;
        try(SocialSupplyInsuranceEmployeesRepository socialSupplyInsuranceEmployeesRepository = new SocialSupplyInsuranceEmployeesRepository()) {
            socialSupplyInsuranceEmployeesEntities = socialSupplyInsuranceEmployeesRepository.select();
        }
        return socialSupplyInsuranceEmployeesEntities;
    }
}
