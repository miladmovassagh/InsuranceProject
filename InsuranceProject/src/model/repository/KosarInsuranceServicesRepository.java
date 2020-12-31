package model.repository;

import model.entity.KosarInsuranceServicesEntity;

import java.sql.*;
import java.util.*;

public class KosarInsuranceServicesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public KosarInsuranceServicesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(KosarInsuranceServicesEntity kosarInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into KosarInsurance(nationalId,insuranceType,contractTerm,registrationDate,paymentTrackingCode,documentNumber,paymentCode,bill,serviceType) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,kosarInsuranceServicesEntity.getNationalId());
        preparedStatement.setString(2,kosarInsuranceServicesEntity.getInsuranceType());
        preparedStatement.setInt(3,kosarInsuranceServicesEntity.getContractTerm());
        preparedStatement.setString(4,kosarInsuranceServicesEntity.getRegistrationDate());
        preparedStatement.setLong(5,kosarInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(6,kosarInsuranceServicesEntity.getDocumentNumber());
        preparedStatement.setLong(7,kosarInsuranceServicesEntity.getPaymentCode());
        preparedStatement.setLong(8,kosarInsuranceServicesEntity.getBill());
        preparedStatement.setString(9,kosarInsuranceServicesEntity.getServiceType());
        preparedStatement.executeUpdate();
    }

    public void update(KosarInsuranceServicesEntity kosarInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update KosarInsurance set bill = ?, paymentTrackingCode = ?, serviceType = ? where paymentCode = ?");
        preparedStatement.setLong(1,kosarInsuranceServicesEntity.getBill());
        preparedStatement.setLong(2,kosarInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(3,kosarInsuranceServicesEntity.getServiceType());
        preparedStatement.setLong(4,kosarInsuranceServicesEntity.getPaymentCode());
        preparedStatement.executeUpdate();
    }

    public void update(long paymentCode, String serviceType) throws Exception {
        preparedStatement = connection.prepareStatement("update KosarInsurance set serviceType = ? where paymentCode = ?");
        preparedStatement.setString(1,serviceType);
        preparedStatement.setLong(2,paymentCode);
        preparedStatement.executeUpdate();
    }

    public List<KosarInsuranceServicesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from KosarInsurance");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<KosarInsuranceServicesEntity> kosarInsuranceServicesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            KosarInsuranceServicesEntity kosarInsuranceServicesEntity = new KosarInsuranceServicesEntity();
            kosarInsuranceServicesEntity.setNationalId(resultSet.getString("nationalId"));
            kosarInsuranceServicesEntity.setInsuranceType(resultSet.getString("insuranceType"));
            kosarInsuranceServicesEntity.setContractTerm(resultSet.getInt("contractTerm"));
            kosarInsuranceServicesEntity.setRegistrationDate(resultSet.getString("registrationDate"));
            kosarInsuranceServicesEntity.setPaymentTrackingCode(resultSet.getLong("paymentTrackingCode"));
            kosarInsuranceServicesEntity.setDocumentNumber(resultSet.getString("documentNumber"));
            kosarInsuranceServicesEntity.setPaymentCode(resultSet.getLong("paymentCode"));
            kosarInsuranceServicesEntity.setBill(resultSet.getLong("bill"));
            kosarInsuranceServicesEntity.setServiceType(resultSet.getString("serviceType"));
            kosarInsuranceServicesEntityList.add(kosarInsuranceServicesEntity);
        }
        return kosarInsuranceServicesEntityList;
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
