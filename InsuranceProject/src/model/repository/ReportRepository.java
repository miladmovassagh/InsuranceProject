package model.repository;

import model.entity.ReportEntity;

import java.sql.*;

public class ReportRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ReportRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(ReportEntity reportEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into centralInsurance(insuranceName,insuranceType,serviceType,contractTerm,registrationDate,paymentCode,insurancePrice,customerNationalId,customerNationality,customerType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, reportEntity.getInsuranceName());
        preparedStatement.setString(2, reportEntity.getInsuranceType());
        preparedStatement.setString(3, reportEntity.getServiceType());
        preparedStatement.setInt(4, reportEntity.getContractTerm());
        preparedStatement.setString(5, reportEntity.getRegistrationDate());
        preparedStatement.setLong(6, reportEntity.getPaymentCode());
        preparedStatement.setLong(7, reportEntity.getInsurancePrice());
        preparedStatement.setString(8, reportEntity.getCustomerNationalId());
        preparedStatement.setString(9, reportEntity.getCustomerNationality());
        preparedStatement.setString(10, reportEntity.getCustomerType());
        preparedStatement.executeUpdate();
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
