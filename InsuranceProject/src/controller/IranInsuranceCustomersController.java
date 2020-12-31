package controller;

import model.entity.IranInsuranceCustomersEntity;
import model.service.IranInsuranceCustomersService;

import java.util.List;

public class IranInsuranceCustomersController {

    private static IranInsuranceCustomersController iranInsuranceCustomersController = new IranInsuranceCustomersController();

    public static IranInsuranceCustomersController getInstance() {
        return iranInsuranceCustomersController;
    }

    private IranInsuranceCustomersController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        if(!select(nationalId))
            IranInsuranceCustomersService.getInstance().save(new IranInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
        else
            update(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
    }

    public void update(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType) throws Exception {
        IranInsuranceCustomersService.getInstance().edit(new IranInsuranceCustomersEntity().setFullName(fullName).setNationalId(nationalId).setCertificateId(certificateId).setFatherName(fatherName).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setNationality(nationality).setUserType(userType));
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<IranInsuranceCustomersEntity> iranInsuranceCustomersList = IranInsuranceCustomersService.getInstance().report();
        for(IranInsuranceCustomersEntity iranInsuranceCustomersEntity : iranInsuranceCustomersList) {
            if(nationalId.equals(iranInsuranceCustomersEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
