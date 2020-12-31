package model.service;

import model.entity.KosarInsuranceCustomersEntity;
import model.repository.KosarInsuranceCustomersRepository;

import java.util.List;

public class KosarInsuranceCustomersService {

    private static KosarInsuranceCustomersService kosarInsuranceCustomersService = new KosarInsuranceCustomersService();

    public static KosarInsuranceCustomersService getInstance() {
        return kosarInsuranceCustomersService;
    }

    private KosarInsuranceCustomersService() {

    }

    public void save(KosarInsuranceCustomersEntity kosarInsuranceCustomersEntity) throws Exception {
        try(KosarInsuranceCustomersRepository kosarInsuranceCustomersRepository = new KosarInsuranceCustomersRepository()) {
            kosarInsuranceCustomersRepository.insert(kosarInsuranceCustomersEntity);
            kosarInsuranceCustomersRepository.commit();
        }
    }

    public void edit(KosarInsuranceCustomersEntity kosarInsuranceCustomersEntity) throws Exception {
        try (KosarInsuranceCustomersRepository kosarInsuranceCustomersRepository = new KosarInsuranceCustomersRepository()) {
            kosarInsuranceCustomersRepository.update(kosarInsuranceCustomersEntity);
            kosarInsuranceCustomersRepository.commit();
        }
    }

    public List<KosarInsuranceCustomersEntity> report() throws Exception {
        List<KosarInsuranceCustomersEntity> kosarInsuranceCustomersEntities;
        try(KosarInsuranceCustomersRepository kosarInsuranceCustomersRepository = new KosarInsuranceCustomersRepository()) {
            kosarInsuranceCustomersEntities = kosarInsuranceCustomersRepository.select();
        }
        return kosarInsuranceCustomersEntities;
    }
}
