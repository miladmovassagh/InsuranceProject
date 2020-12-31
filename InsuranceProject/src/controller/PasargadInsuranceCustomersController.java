package controller;

import model.entity.PasargadInsuranceCustomersEntity;
import model.service.PasargadInsuranceCustomersService;

import java.util.List;

public class PasargadInsuranceCustomersController {

    private static PasargadInsuranceCustomersController pasargadInsuranceCustomersController = new PasargadInsuranceCustomersController();

    public static PasargadInsuranceCustomersController getInstance() {
        return pasargadInsuranceCustomersController;
    }

    private PasargadInsuranceCustomersController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        if(!select(nationalId))
            PasargadInsuranceCustomersService.getInstance().save(new PasargadInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
        else
            update(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
    }

    public void update(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        PasargadInsuranceCustomersService.getInstance().edit(new PasargadInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<PasargadInsuranceCustomersEntity> pasargadInsuranceCustomersList = PasargadInsuranceCustomersService.getInstance().report();
        for(PasargadInsuranceCustomersEntity pasargadInsuranceCustomersEntity : pasargadInsuranceCustomersList) {
            if(nationalId.equals(pasargadInsuranceCustomersEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
