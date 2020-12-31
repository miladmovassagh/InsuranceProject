package controller;

import model.entity.AlborzInsuranceCustomersEntity;
import model.service.AlborzInsuranceCustomersService;

import java.util.List;

public class AlborzInsuranceCustomersController {

    private static AlborzInsuranceCustomersController alborzInsuranceCustomersController = new AlborzInsuranceCustomersController();

    public static AlborzInsuranceCustomersController getInstance() {
        return alborzInsuranceCustomersController;
    }

    private AlborzInsuranceCustomersController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        if(!select(nationalId))
            AlborzInsuranceCustomersService.getInstance().save(new AlborzInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
        else
            update(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
    }

    public void update(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        AlborzInsuranceCustomersService.getInstance().edit(new AlborzInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<AlborzInsuranceCustomersEntity> alborzInsuranceCustomersList = AlborzInsuranceCustomersService.getInstance().report();
        for(AlborzInsuranceCustomersEntity alborzInsuranceCustomersEntity : alborzInsuranceCustomersList) {
            if(nationalId.equals(alborzInsuranceCustomersEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}