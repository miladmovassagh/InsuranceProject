package model.service;

import model.entity.AlborzInsuranceCustomersEntity;
import model.repository.AlborzInsuranceCustomersRepository;

import java.util.List;

public class AlborzInsuranceCustomersService {

    private static AlborzInsuranceCustomersService alborzInsuranceCustomersService = new AlborzInsuranceCustomersService();

    public static AlborzInsuranceCustomersService getInstance() {
        return alborzInsuranceCustomersService;
    }

    private AlborzInsuranceCustomersService() {

    }

    public void save(AlborzInsuranceCustomersEntity alborzInsuranceCustomersEntity) throws Exception {
        try(AlborzInsuranceCustomersRepository alborzInsuranceCustomersRepository = new AlborzInsuranceCustomersRepository()) {
            alborzInsuranceCustomersRepository.insert(alborzInsuranceCustomersEntity);
            alborzInsuranceCustomersRepository.commit();
        }
    }

    public void edit(AlborzInsuranceCustomersEntity alborzInsuranceCustomersEntity) throws Exception {
        try (AlborzInsuranceCustomersRepository alborzInsuranceCustomersRepository = new AlborzInsuranceCustomersRepository()) {
            alborzInsuranceCustomersRepository.update(alborzInsuranceCustomersEntity);
            alborzInsuranceCustomersRepository.commit();
        }
    }

    public List<AlborzInsuranceCustomersEntity> report() throws Exception {
        List<AlborzInsuranceCustomersEntity> alborzInsuranceCustomersEntities;
        try(AlborzInsuranceCustomersRepository alborzInsuranceCustomersRepository = new AlborzInsuranceCustomersRepository()) {
            alborzInsuranceCustomersEntities = alborzInsuranceCustomersRepository.select();
        }
        return alborzInsuranceCustomersEntities;
    }
}
