package model.service;

import model.entity.SocialSupplyInsuranceServicesEntity;
import model.repository.SocialSupplyInsuranceServicesRepository;

import java.util.List;

public class SocialSupplyInsuranceServicesService {

    private static SocialSupplyInsuranceServicesService socialSupplyInsuranceServicesService = new SocialSupplyInsuranceServicesService();

    public static SocialSupplyInsuranceServicesService getInstance() {
        return socialSupplyInsuranceServicesService;
    }

    private SocialSupplyInsuranceServicesService() {

    }

    public void save(SocialSupplyInsuranceServicesEntity socialSupplyInsuranceServicesEntity) throws Exception {
        try(SocialSupplyInsuranceServicesRepository socialSupplyInsuranceServicesRepository = new SocialSupplyInsuranceServicesRepository()) {
            socialSupplyInsuranceServicesRepository.insert(socialSupplyInsuranceServicesEntity);
            socialSupplyInsuranceServicesRepository.commit();
        }
    }

    public void edit(SocialSupplyInsuranceServicesEntity socialSupplyInsuranceServicesEntity) throws Exception {
        try(SocialSupplyInsuranceServicesRepository socialSupplyInsuranceServicesRepository = new SocialSupplyInsuranceServicesRepository()) {
            List<SocialSupplyInsuranceServicesEntity> socialSupplyInsuranceServicesList = SocialSupplyInsuranceServicesService.getInstance().report();
            for (SocialSupplyInsuranceServicesEntity socialSupplyInsuranceServicesEntity1 : socialSupplyInsuranceServicesList) {
                if (socialSupplyInsuranceServicesEntity.getPaymentCode() == socialSupplyInsuranceServicesEntity1.getPaymentCode()) {
                    socialSupplyInsuranceServicesEntity.setBill(socialSupplyInsuranceServicesEntity1.getBill() - socialSupplyInsuranceServicesEntity.getBill());
                    socialSupplyInsuranceServicesRepository.update(socialSupplyInsuranceServicesEntity);
                    socialSupplyInsuranceServicesRepository.commit();
                }
            }
        }
    }

    public void edit(long paymentCode, String serviceType) throws Exception {
        try(SocialSupplyInsuranceServicesRepository socialSupplyInsuranceServicesRepository = new SocialSupplyInsuranceServicesRepository()) {
            socialSupplyInsuranceServicesRepository.update(paymentCode, serviceType);
            socialSupplyInsuranceServicesRepository.commit();
        }
    }

    public List<SocialSupplyInsuranceServicesEntity> report() throws Exception {
        List<SocialSupplyInsuranceServicesEntity> socialSupplyInsuranceServicesEntities;
        try(SocialSupplyInsuranceServicesRepository socialSupplyInsuranceServicesRepository = new SocialSupplyInsuranceServicesRepository()) {
            socialSupplyInsuranceServicesEntities = socialSupplyInsuranceServicesRepository.select();
        }
        return socialSupplyInsuranceServicesEntities;
    }
}
