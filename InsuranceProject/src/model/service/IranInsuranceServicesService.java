package model.service;

import model.entity.IranInsuranceServicesEntity;
import model.repository.IranInsuranceServicesRepository;

import java.util.List;

public class IranInsuranceServicesService {

    private static IranInsuranceServicesService iranInsuranceServicesService = new IranInsuranceServicesService();

    public static IranInsuranceServicesService getInstance() {
        return iranInsuranceServicesService;
    }

    private IranInsuranceServicesService() {

    }

    public void save(IranInsuranceServicesEntity iranInsuranceServicesEntity) throws Exception {
        try(IranInsuranceServicesRepository iranInsuranceServicesRepository = new IranInsuranceServicesRepository()) {
            iranInsuranceServicesRepository.insert(iranInsuranceServicesEntity);
            iranInsuranceServicesRepository.commit();
        }
    }

    public void edit(IranInsuranceServicesEntity iranInsuranceServicesEntity) throws Exception {
        try (IranInsuranceServicesRepository iranInsuranceServicesRepository = new IranInsuranceServicesRepository()) {
            List<IranInsuranceServicesEntity> iranInsuranceServicesList = IranInsuranceServicesService.getInstance().report();
            for (IranInsuranceServicesEntity iranInsuranceServicesEntity1 : iranInsuranceServicesList) {
                if (iranInsuranceServicesEntity.getPaymentCode() == iranInsuranceServicesEntity1.getPaymentCode()) {
                    iranInsuranceServicesEntity.setBill(iranInsuranceServicesEntity1.getBill() - iranInsuranceServicesEntity.getBill());
                    iranInsuranceServicesRepository.update(iranInsuranceServicesEntity);
                    iranInsuranceServicesRepository.commit();
                }
            }
        }
    }

    public void edit(long paymentCode, String serviceType) throws Exception {
        try(IranInsuranceServicesRepository iranInsuranceServicesRepository = new IranInsuranceServicesRepository()) {
            iranInsuranceServicesRepository.update(paymentCode, serviceType);
            iranInsuranceServicesRepository.commit();
        }
    }

    public List<IranInsuranceServicesEntity> report() throws Exception {
        List<IranInsuranceServicesEntity> iranInsuranceServicesEntities;
        try(IranInsuranceServicesRepository iranInsuranceServicesRepository = new IranInsuranceServicesRepository()) {
            iranInsuranceServicesEntities = iranInsuranceServicesRepository.select();
        }
        return iranInsuranceServicesEntities;
    }
}
