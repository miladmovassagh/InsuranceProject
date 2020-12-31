package controller;

import exception.ExceptionManager;
import model.entity.IranInsuranceServicesEntity;
import model.service.IranInsuranceServicesService;
import view.IranInsuranceServices;

import javax.swing.*;
import java.util.List;

public class IranInsuranceServicesController {

    private static IranInsuranceServicesController iranInsuranceServicesController = new IranInsuranceServicesController();

    public static IranInsuranceServicesController getInstance() {
        return iranInsuranceServicesController;
    }

    private IranInsuranceServicesController() {

    }

    public void insert(String fullName, String nationalId, String certificateId, String fatherName, String phoneNumber, String homePhone, String birthDate, String address, String nationality, String userType, String insuranceType, int contractTerm, String registrationDate, long paymentTrackingCode, String documentNumber, long paymentCode, long bill) throws Exception {
        int i;
        if(fullName.equals("") || nationalId.equals("") || certificateId.equals("") || fatherName.equals("") || phoneNumber.equals("") || homePhone.equals("") || address.equals("") || documentNumber.equals(""))
            throw new ExceptionManager("Information cannot be empty");
        for (i = 0; i < fullName.length(); i++)
            if (!Character.isLetter(fullName.charAt(i)) && !Character.isSpaceChar(fullName.charAt(i)))
                throw new ExceptionManager("Full Name can only contain letters and spaces");
        if (nationalId.length() != 10)
            throw new ExceptionManager("Invalid National Id");
        for (i = 0; i < nationalId.length(); i++)
            if (!Character.isDigit(nationalId.charAt(i)))
                throw new ExceptionManager("Invalid National Id");
        for (i = 0; i < certificateId.length(); i++)
            if (!Character.isDigit(certificateId.charAt(i)))
                throw new ExceptionManager("Invalid Certificate Id");
        for (i = 0; i < fatherName.length(); i++)
            if (!Character.isLetter(fatherName.charAt(i)) && !Character.isSpaceChar(fatherName.charAt(i)))
                throw new ExceptionManager("Father Name can only contain letters and spaces");
        if (phoneNumber.length() != 11)
            throw new ExceptionManager("Invalid Phone Number");
        for (i = 0; i < phoneNumber.length(); i++)
            if (!Character.isDigit(phoneNumber.charAt(i)))
                throw new ExceptionManager("Invalid Phone Number");
        if (phoneNumber.charAt(0) != '0' || phoneNumber.charAt(1) != '9')
            throw new ExceptionManager("Please enter the Phone Number as 09XXXXXXXXX");
        if (homePhone.length() != 11)
            throw new ExceptionManager("Invalid Home Phone");
        for (i = 0; i < homePhone.length(); i++)
            if (!Character.isDigit(homePhone.charAt(i)))
                throw new ExceptionManager("Invalid Home Phone");
        if (homePhone.charAt(0) != '0')
            throw new ExceptionManager("Please enter the Home Phone as 0XXXXXXXXXX");
        if ((birthDate.charAt(9) == '1' && birthDate.charAt(8) == '3') && (birthDate.charAt(6) == '7' || birthDate.charAt(6) == '8' || birthDate.charAt(6) == '9' || birthDate.charAt(5) == '1'))
            throw new ExceptionManager("Invalid Birth Date");
        for (i = 0; i < address.length(); i++)
            if (!Character.isLetter(address.charAt(i)) && !Character.isDigit(address.charAt(i)) && !Character.isSpaceChar(address.charAt(i)))
                throw new ExceptionManager("Address cannot contain symbols");
        if (String.valueOf(paymentTrackingCode).length() != 6)
            throw new ExceptionManager("Invalid Payment Tracking Code");
        for (i = 0; i < String.valueOf(paymentTrackingCode).length(); i++)
            if (!Character.isDigit(String.valueOf(paymentTrackingCode).charAt(i)))
                throw new ExceptionManager("Invalid Payment Tracking Code");
        for (i = 0; i < documentNumber.length(); i++)
            if (!Character.isDigit(documentNumber.charAt(i)))
                throw new ExceptionManager("Invalid Document Number");
        if(!select3(nationalId, insuranceType)) {
            IranInsuranceCustomersController.getInstance().insert(fullName, nationalId, certificateId, fatherName, phoneNumber, homePhone, birthDate, address, nationality, userType);
            IranInsuranceServicesService.getInstance().save(new IranInsuranceServicesEntity().setNationalId(nationalId).setInsuranceType(insuranceType).setContractTerm(contractTerm).setRegistrationDate(registrationDate).setPaymentTrackingCode(paymentTrackingCode).setDocumentNumber(documentNumber).setPaymentCode(paymentCode).setBill(bill).setServiceType("register"));
            ReportController.getInstance().insert("iran", insuranceType, "register insurance", contractTerm, registrationDate, paymentCode, bill, nationalId, nationality, userType);
            IranInsuranceServices.jFrame1.dispose();
            JOptionPane.showMessageDialog(null, "Register New Insurance successfully\nCustomer payment code: " + paymentCode + "\nAnnual premium: 1000000 toman\nContract term: " + contractTerm + "\nRegistration date: " + registrationDate);
            new IranInsuranceServices();
        }
        else
            throw new ExceptionManager("The customer is already insured");
    }

    public void update(long paymentCode, long paymentTrackingCode, long bill) throws Exception {
        int i;
        if(String.valueOf(paymentCode).length() != 8)
            throw new ExceptionManager("Invalid Payment Code");
        for(i = 0; i < String.valueOf(paymentCode).length(); i++)
            if(!Character.isDigit(String.valueOf(paymentCode).charAt(i)))
                throw new ExceptionManager("Invalid Payment Code");
        if (String.valueOf(paymentTrackingCode).length() != 6)
            throw new ExceptionManager("Invalid Payment Tracking Code");
        for (i = 0; i < String.valueOf(paymentTrackingCode).length(); i++)
            if (!Character.isDigit(String.valueOf(paymentTrackingCode).charAt(i)))
                throw new ExceptionManager("Invalid Payment Tracking Code");
        if(select(paymentCode)) {
            if(select1(paymentCode)) {
                if(select2(paymentCode)) {
                    IranInsuranceServicesService.getInstance().edit(new IranInsuranceServicesEntity().setPaymentCode(paymentCode).setPaymentTrackingCode(paymentTrackingCode).setBill(bill).setServiceType("pay"));
                    IranInsuranceServices.jFrame2.dispose();
                    JOptionPane.showMessageDialog(null, "Payment was successful\nPayment code:" + paymentCode + "\nAnnual installment:1000000 toman");
                    new IranInsuranceServices();
                }
                else
                    throw new ExceptionManager("The customer in question has no debt");
            }
            else
                throw new ExceptionManager("The insurance has been canceled");
        }
        else
            throw new ExceptionManager("Invalid Payment Code");
    }

    public void update(long paymentCode) throws Exception {
        int i;
        if(String.valueOf(paymentCode).length() != 8)
            throw new ExceptionManager("Invalid Payment Code");
        for(i = 0; i < String.valueOf(paymentCode).length(); i++)
            if(!Character.isDigit(String.valueOf(paymentCode).charAt(i)))
                throw new ExceptionManager("Invalid Payment Code");
        if(select(paymentCode)) {
            if(select1(paymentCode)) {
                if(!select2(paymentCode)) {
                    IranInsuranceServicesService.getInstance().edit(paymentCode, "cancellation");
                    IranInsuranceServices.jFrame3.dispose();
                    JOptionPane.showMessageDialog(null, "Cancellation of the insurance contract was successful\nPayment code:" + paymentCode);
                    new IranInsuranceServices();
                }
                else
                    throw new ExceptionManager("The customer owes");
            }
            else
                throw new ExceptionManager("The insurance has been canceled");
        }
        else
            throw new ExceptionManager("Invalid Payment Code");
    }

    public boolean select(long paymentCode) throws Exception {
        boolean check = false;
        List<IranInsuranceServicesEntity> iranInsuranceServicesList = IranInsuranceServicesService.getInstance().report();
        for(IranInsuranceServicesEntity iranInsuranceServicesEntity : iranInsuranceServicesList) {
            if(paymentCode == iranInsuranceServicesEntity.getPaymentCode()) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean select1(long paymentCode) throws Exception {
        boolean check = false;
        List<IranInsuranceServicesEntity> iranInsuranceServicesList = IranInsuranceServicesService.getInstance().report();
        for(IranInsuranceServicesEntity iranInsuranceServicesEntity : iranInsuranceServicesList) {
            if(paymentCode == iranInsuranceServicesEntity.getPaymentCode() && !iranInsuranceServicesEntity.getServiceType().equals("cancellation")) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean select2(long paymentCode) throws Exception {
        boolean check = false;
        List<IranInsuranceServicesEntity> iranInsuranceServicesList = IranInsuranceServicesService.getInstance().report();
        for(IranInsuranceServicesEntity iranInsuranceServicesEntity : iranInsuranceServicesList) {
            if(paymentCode == iranInsuranceServicesEntity.getPaymentCode() && !iranInsuranceServicesEntity.getServiceType().equals("cancellation") && iranInsuranceServicesEntity.getBill() != 0) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean select3(String nationalId, String insuranceType) throws Exception {
        boolean check = false;
        List<IranInsuranceServicesEntity> iranInsuranceServicesList = IranInsuranceServicesService.getInstance().report();
        for(IranInsuranceServicesEntity iranInsuranceServicesEntity : iranInsuranceServicesList) {
            if(nationalId.equals(iranInsuranceServicesEntity.getNationalId()) && insuranceType.equals(iranInsuranceServicesEntity.getInsuranceType()) && !iranInsuranceServicesEntity.getServiceType().equals("cancellation")) {
                check = true;
                break;
            }
        }
        return check;
    }
}
