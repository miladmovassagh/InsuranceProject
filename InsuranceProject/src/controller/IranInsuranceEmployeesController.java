package controller;

import exception.ExceptionManager;
import model.entity.IranInsuranceEmployeesEntity;
import model.service.IranInsuranceEmployeesService;
import view.IranInsurance;
import view.IranInsuranceEmployeesLogin;
import view.IranInsuranceEmployeesSignUp;
import view.IranInsuranceServices;

import javax.swing.*;
import java.util.*;

public class IranInsuranceEmployeesController {

    private static IranInsuranceEmployeesController iranInsuranceEmployeesController = new IranInsuranceEmployeesController();

    public static IranInsuranceEmployeesController getInstance() {
        return iranInsuranceEmployeesController;
    }

    private IranInsuranceEmployeesController() {

    }

    public void insert(String fullName, String username, String password, String nationalId, String phoneNumber, String homePhone, String birthDate, String address, String email, String education, String studyField, String maritalStatus, int workExperience) throws Exception {
        int i;
        if(fullName.equals("") || username.equals("") || password.equals("") || nationalId.equals("") || phoneNumber.equals("") || homePhone.equals("") || address.equals("") || email.equals("") || education.equals("") || studyField.equals(""))
            throw new ExceptionManager("Information cannot be empty");
        for (i = 0; i < fullName.length(); i++)
            if (!Character.isLetter(fullName.charAt(i)) && !Character.isSpaceChar(fullName.charAt(i)))
                throw new ExceptionManager("Full Name can only contain letters and spaces");
        for (i = 0; i < username.length(); i++)
            if (!Character.isLetter(username.charAt(i)) && !Character.isDigit(username.charAt(i)))
                throw new ExceptionManager("Username can only contain letters and numbers");
        for (i = 0; i < password.length(); i++)
            if (Character.isSpaceChar(password.charAt(i)))
                throw new ExceptionManager("Password cannot contain spaces");
        if (nationalId.length() != 10)
            throw new ExceptionManager("Invalid National Id");
        for (i = 0; i < nationalId.length(); i++)
            if (!Character.isDigit(nationalId.charAt(i)))
                throw new ExceptionManager("Invalid National Id");
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
        for (i = 0; i < email.length(); i++)
            if (Character.isSpaceChar(email.charAt(i)))
                throw new ExceptionManager("Email cannot contain spaces");
        if(email.indexOf('@') == -1 || email.indexOf('.') == -1)
            throw new ExceptionManager("Invalid Email Address");
        for (i = 0; i < education.length(); i++)
            if (!Character.isLetter(education.charAt(i)) && !Character.isSpaceChar(education.charAt(i)))
                throw new ExceptionManager("Education can only contain letters and spaces");
        for (i = 0; i < studyField.length(); i++)
            if (!Character.isLetter(studyField.charAt(i)) && !Character.isSpaceChar(studyField.charAt(i)))
                throw new ExceptionManager("Study Field can only contain letters and spaces");
        if(!select(nationalId)) {
            IranInsuranceEmployeesService.getInstance().save(new IranInsuranceEmployeesEntity().setFullName(fullName).setUsername(username).setPassword(password).setNationalId(nationalId).setPhoneNumber(phoneNumber).setHomePhone(homePhone).setBirthDate(birthDate).setAddress(address).setEmail(email).setEducation(education).setStudyField(studyField).setMaritalStatus(maritalStatus).setWorkExperience(workExperience));
            IranInsuranceEmployeesSignUp.jFrame.dispose();
            JOptionPane.showMessageDialog(null, "Sign Up successfully");
            new IranInsurance();
        }
        else
            throw new ExceptionManager("The employee is already registered");
    }

    public void select(String username, String password) throws Exception {
        if(username.equals("") || password.equals(""))
            throw new ExceptionManager("Username and Password cannot be empty");
        boolean check = false;
        List<IranInsuranceEmployeesEntity> iranInsuranceEmployeesList = IranInsuranceEmployeesService.getInstance().report();
        for(IranInsuranceEmployeesEntity iranInsuranceEmployeesEntity : iranInsuranceEmployeesList)
            if (username.equals(iranInsuranceEmployeesEntity.getUsername()) && password.equals(iranInsuranceEmployeesEntity.getPassword())) {
                check = true;
                new IranInsuranceServices();
                IranInsuranceEmployeesLogin.jFrame.dispose();
            }
        if(!check)
            throw new ExceptionManager("Invalid username or password");
    }

    public boolean select(String nationalId) throws Exception {
        boolean check = false;
        List<IranInsuranceEmployeesEntity> iranInsuranceEmployeesList = IranInsuranceEmployeesService.getInstance().report();
        for(IranInsuranceEmployeesEntity iranInsuranceEmployeesEntity : iranInsuranceEmployeesList) {
            if (nationalId.equals(iranInsuranceEmployeesEntity.getNationalId())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
