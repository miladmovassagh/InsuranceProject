package model.entity;

public class ReportEntity {
    private String insuranceName;
    private String insuranceType;
    private String serviceType;
    private int contractTerm;
    private String registrationDate;
    private long paymentCode;
    private long insurancePrice;
    private String customerNationalId;
    private String customerNationality;
    private String customerType;

    public ReportEntity() {

    }

    public ReportEntity(String insuranceName, String insuranceType, String serviceType, int contractTerm, String registrationDate, long paymentCode, long insurancePrice, String customerNationalId, String customerNationality, String customerType) {
        this.insuranceName = insuranceName;
        this.insuranceType = insuranceType;
        this.serviceType = serviceType;
        this.contractTerm = contractTerm;
        this.registrationDate = registrationDate;
        this.paymentCode = paymentCode;
        this.insurancePrice = insurancePrice;
        this.customerNationalId = customerNationalId;
        this.customerNationality = customerNationality;
        this.customerType = customerType;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public ReportEntity setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
        return this;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public ReportEntity setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
        return this;
    }

    public String getServiceType() {
        return serviceType;
    }

    public ReportEntity setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public int getContractTerm() {
        return contractTerm;
    }

    public ReportEntity setContractTerm(int contractTerm) {
        this.contractTerm = contractTerm;
        return this;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public ReportEntity setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public long getPaymentCode() {
        return paymentCode;
    }

    public ReportEntity setPaymentCode(long paymentCode) {
        this.paymentCode = paymentCode;
        return this;
    }

    public long getInsurancePrice() {
        return insurancePrice;
    }

    public ReportEntity setInsurancePrice(long insurancePrice) {
        this.insurancePrice = insurancePrice;
        return this;
    }

    public String getCustomerNationalId() {
        return customerNationalId;
    }

    public ReportEntity setCustomerNationalId(String customerNationalId) {
        this.customerNationalId = customerNationalId;
        return this;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public ReportEntity setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
        return this;
    }

    public String getCustomerType() {
        return customerType;
    }

    public ReportEntity setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }
}
