package model.repository;

import model.entity.PasargadInsuranceCustomersEntity;

import java.sql.*;
import java.util.*;

public class PasargadInsuranceCustomersRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PasargadInsuranceCustomersRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(PasargadInsuranceCustomersEntity pasargadInsuranceCustomersEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into PasargadInsuranceCustomers(fullName,nationalId,certificateId,fatherName,phoneNumber,homePhone,birthDate,address,nationality,userType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,pasargadInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,pasargadInsuranceCustomersEntity.getNationalId());
        preparedStatement.setString(3,pasargadInsuranceCustomersEntity.getCertificateId());
        preparedStatement.setString(4,pasargadInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(5,pasargadInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(6,pasargadInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(7,pasargadInsuranceCustomersEntity.getBirthDate());
        preparedStatement.setString(8,pasargadInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(9,pasargadInsuranceCustomersEntity.getNationality());
        preparedStatement.setString(10,pasargadInsuranceCustomersEntity.getUserType());
        preparedStatement.executeUpdate();
    }

    public void update(PasargadInsuranceCustomersEntity pasargadInsuranceCustomersEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update PasargadInsuranceCustomers set fullName = ?,fatherName = ?,phoneNumber = ?,homePhone = ?,address = ?,userType = ? where nationalId = ?");
        preparedStatement.setString(1,pasargadInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,pasargadInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(3,pasargadInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(4,pasargadInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(5,pasargadInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(6,pasargadInsuranceCustomersEntity.getUserType());
        preparedStatement.setString(7,pasargadInsuranceCustomersEntity.getNationalId());
        preparedStatement.executeUpdate();
    }

    public List<PasargadInsuranceCustomersEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from PasargadInsuranceCustomers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PasargadInsuranceCustomersEntity> pasargadInsuranceCustomersEntityList = new ArrayList<>();
        while(resultSet.next()) {
            PasargadInsuranceCustomersEntity pasargadInsuranceCustomersEntity = new PasargadInsuranceCustomersEntity();
            pasargadInsuranceCustomersEntity.setFullName(resultSet.getString("fullName"));
            pasargadInsuranceCustomersEntity.setNationalId(resultSet.getString("nationalId"));
            pasargadInsuranceCustomersEntity.setCertificateId(resultSet.getString("certificateId"));
            pasargadInsuranceCustomersEntity.setFatherName(resultSet.getString("fatherName"));
            pasargadInsuranceCustomersEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            pasargadInsuranceCustomersEntity.setHomePhone(resultSet.getString("homePhone"));
            pasargadInsuranceCustomersEntity.setBirthDate(resultSet.getString("birthDate"));
            pasargadInsuranceCustomersEntity.setAddress(resultSet.getString("address"));
            pasargadInsuranceCustomersEntity.setNationality(resultSet.getString("nationality"));
            pasargadInsuranceCustomersEntity.setUserType(resultSet.getString("userType"));
            pasargadInsuranceCustomersEntityList.add(pasargadInsuranceCustomersEntity);
        }
        return pasargadInsuranceCustomersEntityList;
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
