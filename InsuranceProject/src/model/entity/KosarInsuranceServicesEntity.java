package model.entity;

public class KosarInsuranceServicesEntity {
    private String nationalId;
    private String insuranceType;
    private int contractTerm;
    private String registrationDate;
    private long paymentTrackingCode;
    private String documentNumber;
    private long paymentCode;
    private long bill;
    private String serviceType;

    public KosarInsuranceServicesEntity() {

    }

    public KosarInsuranceServicesEntity(String nationalId, String insuranceType, int contractTerm, String registrationDate, long paymentTrackingCode, String documentNumber, long paymentCode, long bill, String serviceType) {
        this.nationalId = nationalId;
        this.insuranceType = insuranceType;
        this.contractTerm = contractTerm;
        this.registrationDate = registrationDate;
        this.paymentTrackingCode = paymentTrackingCode;
        this.documentNumber = documentNumber;
        this.paymentCode = paymentCode;
        this.bill = bill;
        this.serviceType = serviceType;
    }

    public String getNationalId() {
        return nationalId;
    }

    public KosarInsuranceServicesEntity setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public KosarInsuranceServicesEntity setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
        return this;
    }

    public int getContractTerm() {
        return contractTerm;
    }

    public KosarInsuranceServicesEntity setContractTerm(int contractTerm) {
        this.contractTerm = contractTerm;
        return this;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public KosarInsuranceServicesEntity setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public long getPaymentTrackingCode() {
        return paymentTrackingCode;
    }

    public KosarInsuranceServicesEntity setPaymentTrackingCode(long paymentTrackingCode) {
        this.paymentTrackingCode = paymentTrackingCode;
        return this;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public KosarInsuranceServicesEntity setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public long getPaymentCode() {
        return paymentCode;
    }

    public KosarInsuranceServicesEntity setPaymentCode(long paymentCode) {
        this.paymentCode = paymentCode;
        return this;
    }

    public long getBill() {
        return bill;
    }

    public KosarInsuranceServicesEntity setBill(long bill) {
        this.bill = bill;
        return this;
    }

    public String getServiceType() {
        return serviceType;
    }

    public KosarInsuranceServicesEntity setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }
}
