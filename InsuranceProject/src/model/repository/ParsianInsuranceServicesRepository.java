package model.repository;

import model.entity.ParsianInsuranceServicesEntity;

import java.sql.*;
import java.util.*;

public class ParsianInsuranceServicesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ParsianInsuranceServicesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(ParsianInsuranceServicesEntity parsianInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into ParsianInsurance(nationalId,insuranceType,contractTerm,registrationDate,paymentTrackingCode,documentNumber,paymentCode,bill,serviceType) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,parsianInsuranceServicesEntity.getNationalId());
        preparedStatement.setString(2,parsianInsuranceServicesEntity.getInsuranceType());
        preparedStatement.setInt(3,parsianInsuranceServicesEntity.getContractTerm());
        preparedStatement.setString(4,parsianInsuranceServicesEntity.getRegistrationDate());
        preparedStatement.setLong(5,parsianInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(6,parsianInsuranceServicesEntity.getDocumentNumber());
        preparedStatement.setLong(7,parsianInsuranceServicesEntity.getPaymentCode());
        preparedStatement.setLong(8,parsianInsuranceServicesEntity.getBill());
        preparedStatement.setString(9,parsianInsuranceServicesEntity.getServiceType());
        preparedStatement.executeUpdate();
    }

    public void update(ParsianInsuranceServicesEntity parsianInsuranceServicesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update ParsianInsurance set bill = ?, paymentTrackingCode = ?, serviceType = ? where paymentCode = ?");
        preparedStatement.setLong(1,parsianInsuranceServicesEntity.getBill());
        preparedStatement.setLong(2,parsianInsuranceServicesEntity.getPaymentTrackingCode());
        preparedStatement.setString(3,parsianInsuranceServicesEntity.getServiceType());
        preparedStatement.setLong(4,parsianInsuranceServicesEntity.getPaymentCode());
        preparedStatement.executeUpdate();
    }

    public void update(long paymentCode, String serviceType) throws Exception {
        preparedStatement = connection.prepareStatement("update ParsianInsurance set serviceType = ? where paymentCode = ?");
        preparedStatement.setString(1,serviceType);
        preparedStatement.setLong(2,paymentCode);
        preparedStatement.executeUpdate();
    }

    public List<ParsianInsuranceServicesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from ParsianInsurance");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ParsianInsuranceServicesEntity> parsianInsuranceServicesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            ParsianInsuranceServicesEntity parsianInsuranceServicesEntity = new ParsianInsuranceServicesEntity();
            parsianInsuranceServicesEntity.setNationalId(resultSet.getString("nationalId"));
            parsianInsuranceServicesEntity.setInsuranceType(resultSet.getString("insuranceType"));
            parsianInsuranceServicesEntity.setContractTerm(resultSet.getInt("contractTerm"));
            parsianInsuranceServicesEntity.setRegistrationDate(resultSet.getString("registrationDate"));
            parsianInsuranceServicesEntity.setPaymentTrackingCode(resultSet.getLong("paymentTrackingCode"));
            parsianInsuranceServicesEntity.setDocumentNumber(resultSet.getString("documentNumber"));
            parsianInsuranceServicesEntity.setPaymentCode(resultSet.getLong("paymentCode"));
            parsianInsuranceServicesEntity.setBill(resultSet.getLong("bill"));
            parsianInsuranceServicesEntity.setServiceType(resultSet.getString("serviceType"));
            parsianInsuranceServicesEntityList.add(parsianInsuranceServicesEntity);
        }
        return parsianInsuranceServicesEntityList;
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
