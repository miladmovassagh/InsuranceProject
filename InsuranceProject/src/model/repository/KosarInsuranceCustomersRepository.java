package model.repository;

import model.entity.KosarInsuranceCustomersEntity;

import java.sql.*;
import java.util.*;

public class KosarInsuranceCustomersRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public KosarInsuranceCustomersRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(KosarInsuranceCustomersEntity kosarInsuranceCustomersEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into KosarInsuranceCustomers(fullName,nationalId,certificateId,fatherName,phoneNumber,homePhone,birthDate,address,nationality,userType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,kosarInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,kosarInsuranceCustomersEntity.getNationalId());
        preparedStatement.setString(3,kosarInsuranceCustomersEntity.getCertificateId());
        preparedStatement.setString(4,kosarInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(5,kosarInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(6,kosarInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(7,kosarInsuranceCustomersEntity.getBirthDate());
        preparedStatement.setString(8,kosarInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(9,kosarInsuranceCustomersEntity.getNationality());
        preparedStatement.setString(10,kosarInsuranceCustomersEntity.getUserType());
        preparedStatement.executeUpdate();
    }

    public void update(KosarInsuranceCustomersEntity kosarInsuranceCustomersEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update KosarInsuranceCustomers set fullName = ?,fatherName = ?,phoneNumber = ?,homePhone = ?,address = ?,userType = ? where nationalId = ?");
        preparedStatement.setString(1,kosarInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,kosarInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(3,kosarInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(4,kosarInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(5,kosarInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(6,kosarInsuranceCustomersEntity.getUserType());
        preparedStatement.setString(7,kosarInsuranceCustomersEntity.getNationalId());
        preparedStatement.executeUpdate();
    }

    public List<KosarInsuranceCustomersEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from KosarInsuranceCustomers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<KosarInsuranceCustomersEntity> kosarInsuranceCustomersEntityList = new ArrayList<>();
        while(resultSet.next()) {
            KosarInsuranceCustomersEntity kosarInsuranceCustomersEntity = new KosarInsuranceCustomersEntity();
            kosarInsuranceCustomersEntity.setFullName(resultSet.getString("fullName"));
            kosarInsuranceCustomersEntity.setNationalId(resultSet.getString("nationalId"));
            kosarInsuranceCustomersEntity.setCertificateId(resultSet.getString("certificateId"));
            kosarInsuranceCustomersEntity.setFatherName(resultSet.getString("fatherName"));
            kosarInsuranceCustomersEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            kosarInsuranceCustomersEntity.setHomePhone(resultSet.getString("homePhone"));
            kosarInsuranceCustomersEntity.setBirthDate(resultSet.getString("birthDate"));
            kosarInsuranceCustomersEntity.setAddress(resultSet.getString("address"));
            kosarInsuranceCustomersEntity.setNationality(resultSet.getString("nationality"));
            kosarInsuranceCustomersEntity.setUserType(resultSet.getString("userType"));
            kosarInsuranceCustomersEntityList.add(kosarInsuranceCustomersEntity);
        }
        return kosarInsuranceCustomersEntityList;
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
