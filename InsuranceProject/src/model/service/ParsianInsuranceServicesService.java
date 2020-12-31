package model.service;

import model.entity.ParsianInsuranceServicesEntity;
import model.repository.ParsianInsuranceServicesRepository;

import java.util.List;

public class ParsianInsuranceServicesService {

    private static ParsianInsuranceServicesService parsianInsuranceServicesService = new ParsianInsuranceServicesService();

    public static ParsianInsuranceServicesService getInstance() {
        return parsianInsuranceServicesService;
    }

    private ParsianInsuranceServicesService() {

    }

    public void save(ParsianInsuranceServicesEntity parsianInsuranceServicesEntity) throws Exception {
        try(ParsianInsuranceServicesRepository parsianInsuranceServicesRepository = new ParsianInsuranceServicesRepository()) {
            parsianInsuranceServicesRepository.insert(parsianInsuranceServicesEntity);
            parsianInsuranceServicesRepository.commit();
        }
    }

    public void edit(ParsianInsuranceServicesEntity parsianInsuranceServicesEntity) throws Exception {
        try (ParsianInsuranceServicesRepository parsianInsuranceServicesRepository = new ParsianInsuranceServicesRepository()) {
            List<ParsianInsuranceServicesEntity> parsianInsuranceServicesList = ParsianInsuranceServicesService.getInstance().report();
            for (ParsianInsuranceServicesEntity parsianInsuranceServicesEntity1 : parsianInsuranceServicesList) {
                if (parsianInsuranceServicesEntity.getPaymentCode() == parsianInsuranceServicesEntity1.getPaymentCode()) {
                    parsianInsuranceServicesEntity.setBill(parsianInsuranceServicesEntity1.getBill() - parsianInsuranceServicesEntity.getBill());
                    parsianInsuranceServicesRepository.update(parsianInsuranceServicesEntity);
                    parsianInsuranceServicesRepository.commit();
                }
            }
        }
    }

    public void edit(long paymentCode, String serviceType) throws Exception {
        try(ParsianInsuranceServicesRepository parsianInsuranceServicesRepository = new ParsianInsuranceServicesRepository()) {
            parsianInsuranceServicesRepository.update(paymentCode, serviceType);
            parsianInsuranceServicesRepository.commit();
        }
    }

    public List<ParsianInsuranceServicesEntity> report() throws Exception {
        List<ParsianInsuranceServicesEntity> parsianInsuranceServicesEntities;
        try(ParsianInsuranceServicesRepository parsianInsuranceServicesRepository = new ParsianInsuranceServicesRepository()) {
            parsianInsuranceServicesEntities = parsianInsuranceServicesRepository.select();
        }
        return parsianInsuranceServicesEntities;
    }
}
