package model.repository;

import model.entity.SocialSupplyInsuranceServicesEntity;

import java.sql.*;
import java.util.*;

public class SocialSupplyInsuranceServicesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public SocialSupplyInsuranceServicesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(SocialSupplyInsuranceServicesEntity socialSupplyInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into SocialSupplyInsurance(nationalId,insuranceType,contractTerm,registrationDate,paymentTrackingCode,documentNumber,paymentCode,bill,serviceType) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,socialSupplyInsuranceServicesEntity.getNationalId());
        preparedStatement.setString(2,socialSupplyInsuranceServicesEntity.getInsuranceType());
        preparedStatement.setInt(3,socialSupplyInsuranceServicesEntity.getContractTerm());
        preparedStatement.setString(4,socialSupplyInsuranceServicesEntity.getRegistrationDate());
        preparedStatement.setLong(5,socialSupplyInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(6,socialSupplyInsuranceServicesEntity.getDocumentNumber());
        preparedStatement.setLong(7,socialSupplyInsuranceServicesEntity.getPaymentCode());
        preparedStatement.setLong(8,socialSupplyInsuranceServicesEntity.getBill());
        preparedStatement.setString(9,socialSupplyInsuranceServicesEntity.getServiceType());
        preparedStatement.executeUpdate();
    }

    public void update(SocialSupplyInsuranceServicesEntity socialSupplyInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update SocialSupplyInsurance set bill = ?, paymentTrackingCode = ?, serviceType = ? where paymentCode = ?");
        preparedStatement.setLong(1,socialSupplyInsuranceServicesEntity.getBill());
        preparedStatement.setLong(2,socialSupplyInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(3,socialSupplyInsuranceServicesEntity.getServiceType());
        preparedStatement.setLong(4,socialSupplyInsuranceServicesEntity.getPaymentCode());
        preparedStatement.executeUpdate();
    }

    public void update(long paymentCode, String serviceType) throws Exception {
        preparedStatement = connection.prepareStatement("update SocialSupplyInsurance set serviceType = ? where paymentCode = ?");
        preparedStatement.setString(1,serviceType);
        preparedStatement.setLong(2,paymentCode);
        preparedStatement.executeUpdate();
    }

    public List<SocialSupplyInsuranceServicesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from SocialSupplyInsurance");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<SocialSupplyInsuranceServicesEntity> socialSupplyInsuranceServicesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            SocialSupplyInsuranceServicesEntity socialSupplyInsuranceServicesEntity = new SocialSupplyInsuranceServicesEntity();
            socialSupplyInsuranceServicesEntity.setNationalId(resultSet.getString("nationalId"));
            socialSupplyInsuranceServicesEntity.setInsuranceType(resultSet.getString("insuranceType"));
            socialSupplyInsuranceServicesEntity.setContractTerm(resultSet.getInt("contractTerm"));
            socialSupplyInsuranceServicesEntity.setRegistrationDate(resultSet.getString("registrationDate"));
            socialSupplyInsuranceServicesEntity.setPaymentTrackingCode(resultSet.getLong("paymentTrackingCode"));
            socialSupplyInsuranceServicesEntity.setDocumentNumber(resultSet.getString("documentNumber"));
            socialSupplyInsuranceServicesEntity.setPaymentCode(resultSet.getLong("paymentCode"));
            socialSupplyInsuranceServicesEntity.setBill(resultSet.getLong("bill"));
            socialSupplyInsuranceServicesEntity.setServiceType(resultSet.getString("serviceType"));
            socialSupplyInsuranceServicesEntityList.add(socialSupplyInsuranceServicesEntity);
        }
        return socialSupplyInsuranceServicesEntityList;
    }

    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback() throws Exception{
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
