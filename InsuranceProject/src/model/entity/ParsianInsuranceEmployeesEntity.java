package model.entity;

public class ParsianInsuranceEmployeesEntity {
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

    public ParsianInsuranceEmployeesEntity() {

    }

    public ParsianInsuranceEmployeesEntity(String fullName, String username, String password, String nationalId, String phoneNumber, String homePhone, String birthDate, String address, String email, String education, String studyField, String maritalStatus, int workExperience) {
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

    public ParsianInsuranceEmployeesEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ParsianInsuranceEmployeesEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ParsianInsuranceEmployeesEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public ParsianInsuranceEmployeesEntity setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ParsianInsuranceEmployeesEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ParsianInsuranceEmployeesEntity setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ParsianInsuranceEmployeesEntity setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ParsianInsuranceEmployeesEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ParsianInsuranceEmployeesEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public ParsianInsuranceEmployeesEntity setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getStudyField() {
        return studyField;
    }

    public ParsianInsuranceEmployeesEntity setStudyField(String studyField) {
        this.studyField = studyField;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public ParsianInsuranceEmployeesEntity setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public ParsianInsuranceEmployeesEntity setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
        return this;
    }
}
