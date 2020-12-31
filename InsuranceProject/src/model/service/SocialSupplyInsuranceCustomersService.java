package model.service;

import model.entity.SocialSupplyInsuranceCustomersEntity;
import model.repository.SocialSupplyInsuranceCustomersRepository;

import java.util.List;

public class SocialSupplyInsuranceCustomersService {

    private static SocialSupplyInsuranceCustomersService socialSupplyInsuranceCustomersService = new SocialSupplyInsuranceCustomersService();

    public static SocialSupplyInsuranceCustomersService getInstance() {
        return socialSupplyInsuranceCustomersService;
    }

    private SocialSupplyInsuranceCustomersService() {

    }

    public void save(SocialSupplyInsuranceCustomersEntity socialSupplyInsuranceCustomersEntity) throws Exception {
        try(SocialSupplyInsuranceCustomersRepository socialSupplyInsuranceCustomersRepository = new SocialSupplyInsuranceCustomersRepository()) {
            socialSupplyInsuranceCustomersRepository.insert(socialSupplyInsuranceCustomersEntity);
            socialSupplyInsuranceCustomersRepository.commit();
        }
    }

    public void edit(SocialSupplyInsuranceCustomersEntity socialSupplyInsuranceCustomersEntity) throws Exception {
        try (SocialSupplyInsuranceCustomersRepository socialSupplyInsuranceCustomersRepository = new SocialSupplyInsuranceCustomersRepository()) {
            socialSupplyInsuranceCustomersRepository.update(socialSupplyInsuranceCustomersEntity);
            socialSupplyInsuranceCustomersRepository.commit();
        }
    }

    public List<SocialSupplyInsuranceCustomersEntity> report() throws Exception {
        List<SocialSupplyInsuranceCustomersEntity> socialSupplyInsuranceCustomersEntities;
        try(SocialSupplyInsuranceCustomersRepository socialSupplyInsuranceCustomersRepository = new SocialSupplyInsuranceCustomersRepository()) {
            socialSupplyInsuranceCustomersEntities = socialSupplyInsuranceCustomersRepository.select();
        }
        return socialSupplyInsuranceCustomersEntities;
    }
}
