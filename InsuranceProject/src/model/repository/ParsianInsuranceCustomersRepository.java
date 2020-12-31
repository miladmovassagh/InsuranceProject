package model.repository;

import model.entity.ParsianInsuranceCustomersEntity;

import java.sql.*;
import java.util.*;

public class ParsianInsuranceCustomersRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ParsianInsuranceCustomersRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(ParsianInsuranceCustomersEntity parsianInsuranceCustomersEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into ParsianInsuranceCustomers(fullName,nationalId,certificateId,fatherName,phoneNumber,homePhone,birthDate,address,nationality,userType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,parsianInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,parsianInsuranceCustomersEntity.getNationalId());
        preparedStatement.setString(3,parsianInsuranceCustomersEntity.getCertificateId());
        preparedStatement.setString(4,parsianInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(5,parsianInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(6,parsianInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(7,parsianInsuranceCustomersEntity.getBirthDate());
        preparedStatement.setString(8,parsianInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(9,parsianInsuranceCustomersEntity.getNationality());
        preparedStatement.setString(10,parsianInsuranceCustomersEntity.getUserType());
        preparedStatement.executeUpdate();
    }

    public void update(ParsianInsuranceCustomersEntity parsianInsuranceCustomersEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update ParsianInsuranceCustomers set fullName = ?,fatherName = ?,phoneNumber = ?,homePhone = ?,address = ?,userType = ? where nationalId = ?");
        preparedStatement.setString(1,parsianInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,parsianInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(3,parsianInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(4,parsianInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(5,parsianInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(6,parsianInsuranceCustomersEntity.getUserType());
        preparedStatement.setString(7,parsianInsuranceCustomersEntity.getNationalId());
        preparedStatement.executeUpdate();
    }

    public List<ParsianInsuranceCustomersEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from ParsianInsuranceCustomers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ParsianInsuranceCustomersEntity> parsianInsuranceCustomersEntityList = new ArrayList<>();
        while(resultSet.next()) {
            ParsianInsuranceCustomersEntity parsianInsuranceCustomersEntity = new ParsianInsuranceCustomersEntity();
            parsianInsuranceCustomersEntity.setFullName(resultSet.getString("fullName"));
            parsianInsuranceCustomersEntity.setNationalId(resultSet.getString("nationalId"));
            parsianInsuranceCustomersEntity.setCertificateId(resultSet.getString("certificateId"));
            parsianInsuranceCustomersEntity.setFatherName(resultSet.getString("fatherName"));
            parsianInsuranceCustomersEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            parsianInsuranceCustomersEntity.setHomePhone(resultSet.getString("homePhone"));
            parsianInsuranceCustomersEntity.setBirthDate(resultSet.getString("birthDate"));
            parsianInsuranceCustomersEntity.setAddress(resultSet.getString("address"));
            parsianInsuranceCustomersEntity.setNationality(resultSet.getString("nationality"));
            parsianInsuranceCustomersEntity.setUserType(resultSet.getString("userType"));
            parsianInsuranceCustomersEntityList.add(parsianInsuranceCustomersEntity);
        }
        return parsianInsuranceCustomersEntityList;
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
