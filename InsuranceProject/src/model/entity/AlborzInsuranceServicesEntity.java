package model.entity;

public class AlborzInsuranceServicesEntity {
    private String nationalId;
    private String insuranceType;
    private int contractTerm;
    private String registrationDate;
    private long paymentTrackingCode;
    private String documentNumber;
    private long paymentCode;
    private long bill;
    private String serviceType;

    public AlborzInsuranceServicesEntity() {

    }

    public AlborzInsuranceServicesEntity(String nationalId, String insuranceType, int contractTerm, String registrationDate, long paymentTrackingCode, String documentNumber, long paymentCode, long bill, String serviceType) {
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

    public AlborzInsuranceServicesEntity setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public AlborzInsuranceServicesEntity setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
        return this;
    }

    public int getContractTerm() {
        return contractTerm;
    }

    public AlborzInsuranceServicesEntity setContractTerm(int contractTerm) {
        this.contractTerm = contractTerm;
        return this;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public AlborzInsuranceServicesEntity setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public long getPaymentTrackingCode() {
        return paymentTrackingCode;
    }

    public AlborzInsuranceServicesEntity setPaymentTrackingCode(long paymentTrackingCode) {
        this.paymentTrackingCode = paymentTrackingCode;
        return this;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public AlborzInsuranceServicesEntity setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public long getPaymentCode() {
        return paymentCode;
    }

    public AlborzInsuranceServicesEntity setPaymentCode(long paymentCode) {
        this.paymentCode = paymentCode;
        return this;
    }

    public long getBill() {
        return bill;
    }

    public AlborzInsuranceServicesEntity setBill(long bill) {
        this.bill = bill;
        return this;
    }

    public String getServiceType() {
        return serviceType;
    }

    public AlborzInsuranceServicesEntity setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }
}
