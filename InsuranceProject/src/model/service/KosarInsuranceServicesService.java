package model.service;

import model.entity.KosarInsuranceServicesEntity;
import model.repository.KosarInsuranceServicesRepository;

import java.util.List;

public class KosarInsuranceServicesService {

    private static KosarInsuranceServicesService kosarInsuranceServicesService = new KosarInsuranceServicesService();

    public static KosarInsuranceServicesService getInstance() {
        return kosarInsuranceServicesService;
    }

    private KosarInsuranceServicesService() {

    }

    public void save(KosarInsuranceServicesEntity kosarInsuranceServicesEntity) throws Exception {
        try(KosarInsuranceServicesRepository kosarInsuranceServicesRepository = new KosarInsuranceServicesRepository()) {
            kosarInsuranceServicesRepository.insert(kosarInsuranceServicesEntity);
            kosarInsuranceServicesRepository.commit();
        }
    }

    public void edit(KosarInsuranceServicesEntity kosarInsuranceServicesEntity) throws Exception {
        try(KosarInsuranceServicesRepository kosarInsuranceServicesRepository = new KosarInsuranceServicesRepository()) {
            List<KosarInsuranceServicesEntity> kosarInsuranceServicesList = KosarInsuranceServicesService.getInstance().report();
            for (KosarInsuranceServicesEntity kosarInsuranceServicesEntity1 : kosarInsuranceServicesList) {
                if (kosarInsuranceServicesEntity.getPaymentCode() == kosarInsuranceServicesEntity1.getPaymentCode()) {
                    kosarInsuranceServicesEntity.setBill(kosarInsuranceServicesEntity1.getBill() - kosarInsuranceServicesEntity.getBill());
                    kosarInsuranceServicesRepository.update(kosarInsuranceServicesEntity);
                    kosarInsuranceServicesRepository.commit();
                }
            }
        }
    }

    public void edit(long paymentCode, String serviceType) throws Exception {
        try(KosarInsuranceServicesRepository kosarInsuranceServicesRepository = new KosarInsuranceServicesRepository()) {
            kosarInsuranceServicesRepository.update(paymentCode, serviceType);
            kosarInsuranceServicesRepository.commit();
        }
    }

    public List<KosarInsuranceServicesEntity> report() throws Exception {
        List<KosarInsuranceServicesEntity> kosarInsuranceServicesEntities;
        try(KosarInsuranceServicesRepository kosarInsuranceServicesRepository = new KosarInsuranceServicesRepository()) {
            kosarInsuranceServicesEntities = kosarInsuranceServicesRepository.select();
        }
        return kosarInsuranceServicesEntities;
    }
}
