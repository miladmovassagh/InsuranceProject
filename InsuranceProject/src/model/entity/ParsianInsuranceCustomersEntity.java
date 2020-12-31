package model.entity;

public class ParsianInsuranceCustomersEntity {
    private String fullName;
    private String nationalId;
    private String certificateId;
    private String fatherName;
    private String phoneNumber;
    private String homePhone;
    private String birthDate;
    private String address;
    private String nationality;
    private String userType;

    public ParsianInsuranceCustomersEntity() {

    }

    public ParsianInsuranceCustomersEntity(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) {
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.certificateId = certificateId;
        this.fatherName = fatherName;
        this.phoneNumber = phoneNumber;
        this.homePhone = homePhone;
        this.birthDate = birthDate;
        this.address = address;
        this.nationality = nationality;
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public ParsianInsuranceCustomersEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public ParsianInsuranceCustomersEntity setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public ParsianInsuranceCustomersEntity setCertificateId(String certificateId) {
        this.certificateId = certificateId;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public ParsianInsuranceCustomersEntity setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ParsianInsuranceCustomersEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ParsianInsuranceCustomersEntity setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ParsianInsuranceCustomersEntity setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ParsianInsuranceCustomersEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public ParsianInsuranceCustomersEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public ParsianInsuranceCustomersEntity setUserType(String userType) {
        this.userType = userType;
        return this;
    }
}
