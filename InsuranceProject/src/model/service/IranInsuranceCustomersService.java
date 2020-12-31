package model.service;

import model.entity.IranInsuranceCustomersEntity;
import model.repository.IranInsuranceCustomersRepository;

import java.util.List;

public class IranInsuranceCustomersService {

    private static IranInsuranceCustomersService iranInsuranceCustomersService = new IranInsuranceCustomersService();

    public static IranInsuranceCustomersService getInstance() {
        return iranInsuranceCustomersService;
    }

    private IranInsuranceCustomersService() {

    }

    public void save(IranInsuranceCustomersEntity iranInsuranceCustomersEntity) throws Exception {
        try(IranInsuranceCustomersRepository iranInsuranceCustomersRepository = new IranInsuranceCustomersRepository()) {
            iranInsuranceCustomersRepository.insert(iranInsuranceCustomersEntity);
            iranInsuranceCustomersRepository.commit();
        }
    }

    public void edit(IranInsuranceCustomersEntity iranInsuranceCustomersEntity) throws Exception {
        try (IranInsuranceCustomersRepository iranInsuranceCustomersRepository = new IranInsuranceCustomersRepository()) {
            iranInsuranceCustomersRepository.update(iranInsuranceCustomersEntity);
            iranInsuranceCustomersRepository.commit();
        }
    }

    public List<IranInsuranceCustomersEntity> report() throws Exception {
        List<IranInsuranceCustomersEntity> iranInsuranceCustomersEntities;
        try(IranInsuranceCustomersRepository iranInsuranceCustomersRepository = new IranInsuranceCustomersRepository()) {
            iranInsuranceCustomersEntities = iranInsuranceCustomersRepository.select();
        }
        return iranInsuranceCustomersEntities;
    }
}
