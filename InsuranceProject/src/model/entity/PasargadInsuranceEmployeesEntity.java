package model.entity;

public class PasargadInsuranceEmployeesEntity {
    private String fullName;
    private String username;
    private String password;
    private String nationalId;
    private String phoneNumber;
    private String homePhone;
    private String birthDate;
    private String address;
    private String email;
    private String education;
    private String studyField;
    private String maritalStatus;
    private int workExperience;

    public PasargadInsuranceEmployeesEntity() {

    }

    public PasargadInsuranceEmployeesEntity(String fullName, String username, String password, String nationalId, String phoneNumber, String homePhone, String birthDate, String address, String email, String education, String studyField, String maritalStatus, int workExperience) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
        this.homePhone = homePhone;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.education = education;
        this.studyField = studyField;
        this.maritalStatus = maritalStatus;
        this.workExperience = workExperience;
    }

    public String getFullName() {
        return fullName;
    }

    public PasargadInsuranceEmployeesEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PasargadInsuranceEmployeesEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PasargadInsuranceEmployeesEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public PasargadInsuranceEmployeesEntity setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PasargadInsuranceEmployeesEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public PasargadInsuranceEmployeesEntity setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PasargadInsuranceEmployeesEntity setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PasargadInsuranceEmployeesEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PasargadInsuranceEmployeesEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public PasargadInsuranceEmployeesEntity setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getStudyField() {
        return studyField;
    }

    public PasargadInsuranceEmployeesEntity setStudyField(String studyField) {
        this.studyField = studyField;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public PasargadInsuranceEmployeesEntity setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public PasargadInsuranceEmployeesEntity setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
        return this;
    }
}
