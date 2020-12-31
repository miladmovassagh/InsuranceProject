package model.repository;

import model.entity.AlborzInsuranceServicesEntity;

import java.sql.*;
import java.util.*;

public class AlborzInsuranceServicesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public AlborzInsuranceServicesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(AlborzInsuranceServicesEntity alborzInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into AlborzInsurance(nationalId,insuranceType,contractTerm,registrationDate,paymentTrackingCode,documentNumber,paymentCode,bill,serviceType) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,alborzInsuranceServicesEntity.getNationalId());
        preparedStatement.setString(2,alborzInsuranceServicesEntity.getInsuranceType());
        preparedStatement.setInt(3,alborzInsuranceServicesEntity.getContractTerm());
        preparedStatement.setString(4,alborzInsuranceServicesEntity.getRegistrationDate());
        preparedStatement.setLong(5,alborzInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(6,alborzInsuranceServicesEntity.getDocumentNumber());
        preparedStatement.setLong(7,alborzInsuranceServicesEntity.getPaymentCode());
        preparedStatement.setLong(8,alborzInsuranceServicesEntity.getBill());
        preparedStatement.setString(9,alborzInsuranceServicesEntity.getServiceType());
        preparedStatement.executeUpdate();
    }

    public void update(AlborzInsuranceServicesEntity alborzInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update AlborzInsurance set bill = ?, paymentTrackingCode = ?, serviceType = ? where paymentCode = ?");
        preparedStatement.setLong(1,alborzInsuranceServicesEntity.getBill());
        preparedStatement.setLong(2,alborzInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(3,alborzInsuranceServicesEntity.getServiceType());
        preparedStatement.setLong(4,alborzInsuranceServicesEntity.getPaymentCode());
        preparedStatement.executeUpdate();
    }

    public void update(long paymentCode, String serviceType) throws Exception {
        preparedStatement = connection.prepareStatement("update AlborzInsurance set serviceType = ? where paymentCode = ?");
        preparedStatement.setString(1,serviceType);
        preparedStatement.setLong(2,paymentCode);
        preparedStatement.executeUpdate();
    }

    public List<AlborzInsuranceServicesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from AlborzInsurance");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<AlborzInsuranceServicesEntity> alborzInsuranceServicesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            AlborzInsuranceServicesEntity alborzInsuranceServicesEntity = new AlborzInsuranceServicesEntity();
            alborzInsuranceServicesEntity.setNationalId(resultSet.getString("nationalId"));
            alborzInsuranceServicesEntity.setInsuranceType(resultSet.getString("insuranceType"));
            alborzInsuranceServicesEntity.setContractTerm(resultSet.getInt("contractTerm"));
            alborzInsuranceServicesEntity.setRegistrationDate(resultSet.getString("registrationDate"));
            alborzInsuranceServicesEntity.setPaymentTrackingCode(resultSet.getLong("paymentTrackingCode"));
            alborzInsuranceServicesEntity.setDocumentNumber(resultSet.getString("documentNumber"));
            alborzInsuranceServicesEntity.setPaymentCode(resultSet.getLong("paymentCode"));
            alborzInsuranceServicesEntity.setBill(resultSet.getLong("bill"));
            alborzInsuranceServicesEntity.setServiceType(resultSet.getString("serviceType"));
            alborzInsuranceServicesEntityList.add(alborzInsuranceServicesEntity);
        }
        return alborzInsuranceServicesEntityList;
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