package controller;

import model.entity.ReportEntity;
import model.service.ReportService;

public class ReportController {

    private static ReportController reportController = new ReportController();

    public static ReportController getInstance() {
        return reportController;
    }

    private ReportController() {

    }

    public void insert(String insuranceName, String insuranceType, String serviceType, int contractTerm, String registrationDate, long paymentCode, long insurancePrice, String customerNationalId, String customerNationality, String customerType) throws Exception {
        ReportService.getInstance().save(new ReportEntity().setInsuranceName(insuranceName).setInsuranceType(insuranceType).setServiceType(serviceType).setContractTerm(contractTerm).setRegistrationDate(registrationDate).setPaymentCode(paymentCode).setInsurancePrice(insurancePrice).setCustomerNationalId(customerNationalId).setCustomerNationality(customerNationality).setCustomerType(customerType));
    }
}
