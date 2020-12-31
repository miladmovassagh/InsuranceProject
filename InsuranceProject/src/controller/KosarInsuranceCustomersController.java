package controller;

import model.entity.KosarInsuranceCustomersEntity;
import model.service.KosarInsuranceCustomersService;

import java.util.List;

public class KosarInsuranceCustomersController {

    private static KosarInsuranceCustomersController kosarInsuranceCustomersController = new KosarInsuranceCustomersController();

    public static KosarInsuranceCustomersController getInstance() {
        return kosarInsuranceCustomersController;
    }

    private KosarInsuranceCustomersController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        if(!select(nationalId))
            KosarInsuranceCustomersService.getInstance().save(new KosarInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
        else
            update(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
    }

    public void update(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        KosarInsuranceCustomersService.getInstance().edit(new KosarInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<KosarInsuranceCustomersEntity> kosarInsuranceCustomersList = KosarInsuranceCustomersService.getInstance().report();
        for(KosarInsuranceCustomersEntity kosarInsuranceCustomersEntity : kosarInsuranceCustomersList) {
            if(nationalId.equals(kosarInsuranceCustomersEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
