package model.service;

import model.entity.AlborzInsuranceServicesEntity;
import model.repository.AlborzInsuranceServicesRepository;

import java.util.List;

public class AlborzInsuranceServicesService {

    private static AlborzInsuranceServicesService alborzInsuranceServicesService = new AlborzInsuranceServicesService();

    public static AlborzInsuranceServicesService getInstance() {
        return alborzInsuranceServicesService;
    }

    private AlborzInsuranceServicesService() {

    }

    public void save(AlborzInsuranceServicesEntity alborzInsuranceServicesEntity) throws Exception {
        try(AlborzInsuranceServicesRepository alborzInsuranceServicesRepository = new AlborzInsuranceServicesRepository()) {
            alborzInsuranceServicesRepository.insert(alborzInsuranceServicesEntity);
            alborzInsuranceServicesRepository.commit();
        }
    }

    public void edit(AlborzInsuranceServicesEntity alborzInsuranceServicesEntity) throws Exception {
        try (AlborzInsuranceServicesRepository alborzInsuranceServicesRepository = new AlborzInsuranceServicesRepository()) {
            List<AlborzInsuranceServicesEntity> alborzInsuranceServicesList = AlborzInsuranceServicesService.getInstance().report();
            for (AlborzInsuranceServicesEntity alborzInsuranceServicesEntity1 : alborzInsuranceServicesList) {
                if (alborzInsuranceServicesEntity.getPaymentCode() == alborzInsuranceServicesEntity1.getPaymentCode()) {
                    alborzInsuranceServicesEntity.setBill(alborzInsuranceServicesEntity1.getBill() - alborzInsuranceServicesEntity.getBill());
                    alborzInsuranceServicesRepository.update(alborzInsuranceServicesEntity);
                    alborzInsuranceServicesRepository.commit();
                }
            }
        }
    }

    public void edit(long paymentCode, String serviceType) throws Exception {
        try(AlborzInsuranceServicesRepository alborzInsuranceServicesRepository = new AlborzInsuranceServicesRepository()) {
            alborzInsuranceServicesRepository.update(paymentCode, serviceType);
            alborzInsuranceServicesRepository.commit();
        }
    }

    public List<AlborzInsuranceServicesEntity> report() throws Exception {
        List<AlborzInsuranceServicesEntity> alborzInsuranceServicesEntities;
        try(AlborzInsuranceServicesRepository alborzInsuranceServicesRepository = new AlborzInsuranceServicesRepository()) {
            alborzInsuranceServicesEntities = alborzInsuranceServicesRepository.select();
        }
        return alborzInsuranceServicesEntities;
    }
}
