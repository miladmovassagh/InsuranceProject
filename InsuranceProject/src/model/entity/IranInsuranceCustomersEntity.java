package model.entity;

public class IranInsuranceCustomersEntity {
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

    public IranInsuranceCustomersEntity() {

    }

    public IranInsuranceCustomersEntity(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) {
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

    public IranInsuranceCustomersEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public IranInsuranceCustomersEntity setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public IranInsuranceCustomersEntity setCertificateId(String certificateId) {
        this.certificateId = certificateId;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public IranInsuranceCustomersEntity setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public IranInsuranceCustomersEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public IranInsuranceCustomersEntity setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public IranInsuranceCustomersEntity setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public IranInsuranceCustomersEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public IranInsuranceCustomersEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public IranInsuranceCustomersEntity setUserType(String userType) {
        this.userType = userType;
        return this;
    }
}
