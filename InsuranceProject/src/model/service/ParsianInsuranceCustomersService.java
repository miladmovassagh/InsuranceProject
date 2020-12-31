package model.service;

import model.entity.ParsianInsuranceCustomersEntity;
import model.repository.ParsianInsuranceCustomersRepository;

import java.util.List;

public class ParsianInsuranceCustomersService {

    private static ParsianInsuranceCustomersService parsianInsuranceCustomersService = new ParsianInsuranceCustomersService();

    public static ParsianInsuranceCustomersService getInstance() {
        return parsianInsuranceCustomersService;
    }

    private ParsianInsuranceCustomersService() {

    }

    public void save(ParsianInsuranceCustomersEntity parsianInsuranceCustomersEntity) throws Exception {
        try(ParsianInsuranceCustomersRepository parsianInsuranceCustomersRepository = new ParsianInsuranceCustomersRepository()) {
            parsianInsuranceCustomersRepository.insert(parsianInsuranceCustomersEntity);
            parsianInsuranceCustomersRepository.commit();
        }
    }

    public void edit(ParsianInsuranceCustomersEntity parsianInsuranceCustomersEntity) throws Exception {
        try(ParsianInsuranceCustomersRepository parsianInsuranceCustomersRepository = new ParsianInsuranceCustomersRepository()) {
            parsianInsuranceCustomersRepository.update(parsianInsuranceCustomersEntity);
            parsianInsuranceCustomersRepository.commit();
        }
    }

    public List<ParsianInsuranceCustomersEntity> report() throws Exception {
        List<ParsianInsuranceCustomersEntity> parsianInsuranceCustomersEntities;
        try(ParsianInsuranceCustomersRepository parsianInsuranceCustomersRepository = new ParsianInsuranceCustomersRepository()) {
            parsianInsuranceCustomersEntities = parsianInsuranceCustomersRepository.select();
        }
        return parsianInsuranceCustomersEntities;
    }
}
