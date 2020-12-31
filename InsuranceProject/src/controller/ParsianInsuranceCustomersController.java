package controller;

import model.entity.ParsianInsuranceCustomersEntity;
import model.service.ParsianInsuranceCustomersService;

import java.util.List;

public class ParsianInsuranceCustomersController {

    private static ParsianInsuranceCustomersController parsianInsuranceCustomersController = new ParsianInsuranceCustomersController();

    public static ParsianInsuranceCustomersController getInstance() {
        return parsianInsuranceCustomersController;
    }

    private ParsianInsuranceCustomersController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        if(!select(nationalId))
            ParsianInsuranceCustomersService.getInstance().save(new ParsianInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
        else
            update(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
    }

    public void update(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        ParsianInsuranceCustomersService.getInstance().edit(new ParsianInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<ParsianInsuranceCustomersEntity> parsianInsuranceCustomersList = ParsianInsuranceCustomersService.getInstance().report();
        for(ParsianInsuranceCustomersEntity parsianInsuranceCustomersEntity : parsianInsuranceCustomersList) {
            if(nationalId.equals(parsianInsuranceCustomersEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
