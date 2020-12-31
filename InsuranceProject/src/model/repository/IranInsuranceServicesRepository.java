package model.repository;

import model.entity.IranInsuranceServicesEntity;

import java.sql.*;
import java.util.*;

public class IranInsuranceServicesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public IranInsuranceServicesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(IranInsuranceServicesEntity iranInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into IranInsurance(nationalId,insuranceType,contractTerm,registrationDate,paymentTrackingCode,documentNumber,paymentCode,bill,serviceType) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,iranInsuranceServicesEntity.getNationalId());
        preparedStatement.setString(2,iranInsuranceServicesEntity.getInsuranceType());
        preparedStatement.setInt(3,iranInsuranceServicesEntity.getContractTerm());
        preparedStatement.setString(4,iranInsuranceServicesEntity.getRegistrationDate());
        preparedStatement.setLong(5,iranInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(6,iranInsuranceServicesEntity.getDocumentNumber());
        preparedStatement.setLong(7,iranInsuranceServicesEntity.getPaymentCode());
        preparedStatement.setLong(8,iranInsuranceServicesEntity.getBill());
        preparedStatement.setString(9,iranInsuranceServicesEntity.getServiceType());
        preparedStatement.executeUpdate();
    }

    public void update(IranInsuranceServicesEntity iranInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update IranInsurance set bill = ?, paymentTrackingCode = ?, serviceType = ? where paymentCode = ?");
        preparedStatement.setLong(1,iranInsuranceServicesEntity.getBill());
        preparedStatement.setLong(2,iranInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(3,iranInsuranceServicesEntity.getServiceType());
        preparedStatement.setLong(4,iranInsuranceServicesEntity.getPaymentCode());
        preparedStatement.executeUpdate();
    }

    public void update(long paymentCode, String serviceType) throws Exception {
        preparedStatement = connection.prepareStatement("update IranInsurance set serviceType = ? where paymentCode = ?");
        preparedStatement.setString(1,serviceType);
        preparedStatement.setLong(2,paymentCode);
        preparedStatement.executeUpdate();
    }

    public List<IranInsuranceServicesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from IranInsurance");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<IranInsuranceServicesEntity> iranInsuranceServicesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            IranInsuranceServicesEntity iranInsuranceServicesEntity = new IranInsuranceServicesEntity();
            iranInsuranceServicesEntity.setNationalId(resultSet.getString("nationalId"));
            iranInsuranceServicesEntity.setInsuranceType(resultSet.getString("insuranceType"));
            iranInsuranceServicesEntity.setContractTerm(resultSet.getInt("contractTerm"));
            iranInsuranceServicesEntity.setRegistrationDate(resultSet.getString("registrationDate"));
            iranInsuranceServicesEntity.setPaymentTrackingCode(resultSet.getLong("paymentTrackingCode"));
            iranInsuranceServicesEntity.setDocumentNumber(resultSet.getString("documentNumber"));
            iranInsuranceServicesEntity.setPaymentCode(resultSet.getLong("paymentCode"));
            iranInsuranceServicesEntity.setBill(resultSet.getLong("bill"));
            iranInsuranceServicesEntity.setServiceType(resultSet.getString("serviceType"));
            iranInsuranceServicesEntityList.add(iranInsuranceServicesEntity);
        }
        return iranInsuranceServicesEntityList;
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
