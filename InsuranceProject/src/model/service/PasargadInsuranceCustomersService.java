package model.service;

import model.entity.PasargadInsuranceCustomersEntity;
import model.repository.PasargadInsuranceCustomersRepository;

import java.util.List;

public class PasargadInsuranceCustomersService {

    private static PasargadInsuranceCustomersService pasargadInsuranceCustomersService = new PasargadInsuranceCustomersService();

    public static PasargadInsuranceCustomersService getInstance() {
        return pasargadInsuranceCustomersService;
    }

    private PasargadInsuranceCustomersService() {

    }

    public void save(PasargadInsuranceCustomersEntity pasargadInsuranceCustomersEntity) throws Exception {
        try(PasargadInsuranceCustomersRepository pasargadInsuranceCustomersRepository = new PasargadInsuranceCustomersRepository()) {
            pasargadInsuranceCustomersRepository.insert(pasargadInsuranceCustomersEntity);
            pasargadInsuranceCustomersRepository.commit();
        }
    }

    public void edit(PasargadInsuranceCustomersEntity pasargadInsuranceCustomersEntity) throws Exception {
        try (PasargadInsuranceCustomersRepository pasargadInsuranceCustomersRepository = new PasargadInsuranceCustomersRepository()) {
            pasargadInsuranceCustomersRepository.update(pasargadInsuranceCustomersEntity);
            pasargadInsuranceCustomersRepository.commit();
        }
    }

    public List<PasargadInsuranceCustomersEntity> report() throws Exception {
        List<PasargadInsuranceCustomersEntity> pasargadInsuranceCustomersEntities;
        try(PasargadInsuranceCustomersRepository pasargadInsuranceCustomersRepository = new PasargadInsuranceCustomersRepository()) {
            pasargadInsuranceCustomersEntities = pasargadInsuranceCustomersRepository.select();
        }
        return pasargadInsuranceCustomersEntities;
    }
}
