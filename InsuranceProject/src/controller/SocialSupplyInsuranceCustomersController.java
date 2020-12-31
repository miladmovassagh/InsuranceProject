package controller;

import model.entity.SocialSupplyInsuranceCustomersEntity;
import model.service.SocialSupplyInsuranceCustomersService;

import java.util.List;

public class SocialSupplyInsuranceCustomersController {

    private static SocialSupplyInsuranceCustomersController socialSupplyInsuranceCustomersController = new SocialSupplyInsuranceCustomersController();

    public static SocialSupplyInsuranceCustomersController getInstance() {
        return socialSupplyInsuranceCustomersController;
    }

    private SocialSupplyInsuranceCustomersController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        if(!select(nationalId))
            SocialSupplyInsuranceCustomersService.getInstance().save(new SocialSupplyInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
        else
            update(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
    }

    public void update(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        SocialSupplyInsuranceCustomersService.getInstance().edit(new SocialSupplyInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<SocialSupplyInsuranceCustomersEntity> socialSupplyInsuranceCustomersList = SocialSupplyInsuranceCustomersService.getInstance().report();
        for(SocialSupplyInsuranceCustomersEntity socialSupplyInsuranceCustomersEntity : socialSupplyInsuranceCustomersList) {
            if(nationalId.equals(socialSupplyInsuranceCustomersEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
