package model.repository;

import model.entity.PasargadInsuranceServicesEntity;

import java.sql.*;
import java.util.*;

public class PasargadInsuranceServicesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PasargadInsuranceServicesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(PasargadInsuranceServicesEntity pasargadInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into PasargadInsurance(nationalId,insuranceType,contractTerm,registrationDate,paymentTrackingCode,documentNumber,paymentCode,bill,serviceType) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,pasargadInsuranceServicesEntity.getNationalId());
        preparedStatement.setString(2,pasargadInsuranceServicesEntity.getInsuranceType());
        preparedStatement.setInt(3,pasargadInsuranceServicesEntity.getContractTerm());
        preparedStatement.setString(4,pasargadInsuranceServicesEntity.getRegistrationDate());
        preparedStatement.setLong(5,pasargadInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(6,pasargadInsuranceServicesEntity.getDocumentNumber());
        preparedStatement.setLong(7,pasargadInsuranceServicesEntity.getPaymentCode());
        preparedStatement.setLong(8,pasargadInsuranceServicesEntity.getBill());
        preparedStatement.setString(9,pasargadInsuranceServicesEntity.getServiceType());
        preparedStatement.executeUpdate();
    }

    public void update(PasargadInsuranceServicesEntity pasargadInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update PasargadInsurance set bill = ?, paymentTrackingCode = ?, serviceType = ? where paymentCode = ?");
        preparedStatement.setLong(1,pasargadInsuranceServicesEntity.getBill());
        preparedStatement.setLong(2,pasargadInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(3,pasargadInsuranceServicesEntity.getServiceType());
        preparedStatement.setLong(4,pasargadInsuranceServicesEntity.getPaymentCode());
        preparedStatement.executeUpdate();
    }

    public void update(long paymentCode, String serviceType) throws Exception {
        preparedStatement = connection.prepareStatement("update PasargadInsurance set serviceType = ? where paymentCode = ?");
        preparedStatement.setString(1,serviceType);
        preparedStatement.setLong(2,paymentCode);
        preparedStatement.executeUpdate();
    }

    public List<PasargadInsuranceServicesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from PasargadInsurance");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PasargadInsuranceServicesEntity> pasargadInsuranceServicesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            PasargadInsuranceServicesEntity pasargadInsuranceServicesEntity = new PasargadInsuranceServicesEntity();
            pasargadInsuranceServicesEntity.setNationalId(resultSet.getString("nationalId"));
            pasargadInsuranceServicesEntity.setInsuranceType(resultSet.getString("insuranceType"));
            pasargadInsuranceServicesEntity.setContractTerm(resultSet.getInt("contractTerm"));
            pasargadInsuranceServicesEntity.setRegistrationDate(resultSet.getString("registrationDate"));
            pasargadInsuranceServicesEntity.setPaymentTrackingCode(resultSet.getLong("paymentTrackingCode"));
            pasargadInsuranceServicesEntity.setDocumentNumber(resultSet.getString("documentNumber"));
            pasargadInsuranceServicesEntity.setPaymentCode(resultSet.getLong("paymentCode"));
            pasargadInsuranceServicesEntity.setBill(resultSet.getLong("bill"));
            pasargadInsuranceServicesEntity.setServiceType(resultSet.getString("serviceType"));
            pasargadInsuranceServicesEntityList.add(pasargadInsuranceServicesEntity);
        }
        return pasargadInsuranceServicesEntityList;
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
