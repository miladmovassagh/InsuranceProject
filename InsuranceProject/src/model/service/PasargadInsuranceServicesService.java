package model.service;

import model.entity.PasargadInsuranceServicesEntity;
import model.repository.PasargadInsuranceServicesRepository;

import java.util.List;

public class PasargadInsuranceServicesService {

    private static PasargadInsuranceServicesService pasargadInsuranceServicesService = new PasargadInsuranceServicesService();

    public static PasargadInsuranceServicesService getInstance() {
        return pasargadInsuranceServicesService;
    }

    private PasargadInsuranceServicesService() {

    }

    public void save(PasargadInsuranceServicesEntity pasargadInsuranceServicesEntity) throws Exception {
        try(PasargadInsuranceServicesRepository pasargadInsuranceServicesRepository = new PasargadInsuranceServicesRepository()) {
            pasargadInsuranceServicesRepository.insert(pasargadInsuranceServicesEntity);
            pasargadInsuranceServicesRepository.commit();
        }
    }

    public void edit(PasargadInsuranceServicesEntity pasargadInsuranceServicesEntity) throws Exception {
        try(PasargadInsuranceServicesRepository pasargadInsuranceServicesRepository = new PasargadInsuranceServicesRepository()) {
            List<PasargadInsuranceServicesEntity> pasargadInsuranceServicesList = PasargadInsuranceServicesService.getInstance().report();
            for (PasargadInsuranceServicesEntity pasargadInsuranceServicesEntity1 : pasargadInsuranceServicesList) {
                if (pasargadInsuranceServicesEntity.getPaymentCode() == pasargadInsuranceServicesEntity1.getPaymentCode()) {
                    pasargadInsuranceServicesEntity.setBill(pasargadInsuranceServicesEntity1.getBill() - pasargadInsuranceServicesEntity.getBill());
                    pasargadInsuranceServicesRepository.update(pasargadInsuranceServicesEntity);
                    pasargadInsuranceServicesRepository.commit();
                }
            }
        }
    }

    public void edit(long paymentCode, String serviceType) throws Exception {
        try(PasargadInsuranceServicesRepository pasargadInsuranceServicesRepository = new PasargadInsuranceServicesRepository()) {
            pasargadInsuranceServicesRepository.update(paymentCode, serviceType);
            pasargadInsuranceServicesRepository.commit();
        }
    }

    public List<PasargadInsuranceServicesEntity> report() throws Exception {
        List<PasargadInsuranceServicesEntity> pasargadInsuranceServicesEntities;
        try(PasargadInsuranceServicesRepository pasargadInsuranceServicesRepository = new PasargadInsuranceServicesRepository()) {
            pasargadInsuranceServicesEntities = pasargadInsuranceServicesRepository.select();
        }
        return pasargadInsuranceServicesEntities;
    }
}
