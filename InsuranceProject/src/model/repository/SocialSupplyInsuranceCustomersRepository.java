package model.repository;

import model.entity.SocialSupplyInsuranceCustomersEntity;

import java.sql.*;
import java.util.*;

public class SocialSupplyInsuranceCustomersRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public SocialSupplyInsuranceCustomersRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(SocialSupplyInsuranceCustomersEntity socialSupplyInsuranceCustomersEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into SocialSupplyInsuranceCustomers(fullName,nationalId,certificateId,fatherName,phoneNumber,homePhone,birthDate,address,nationality,userType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,socialSupplyInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,socialSupplyInsuranceCustomersEntity.getNationalId());
        preparedStatement.setString(3,socialSupplyInsuranceCustomersEntity.getCertificateId());
        preparedStatement.setString(4,socialSupplyInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(5,socialSupplyInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(6,socialSupplyInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(7,socialSupplyInsuranceCustomersEntity.getBirthDate());
        preparedStatement.setString(8,socialSupplyInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(9,socialSupplyInsuranceCustomersEntity.getNationality());
        preparedStatement.setString(10,socialSupplyInsuranceCustomersEntity.getUserType());
        preparedStatement.executeUpdate();
    }

    public void update(SocialSupplyInsuranceCustomersEntity socialSupplyInsuranceCustomersEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update SocialSupplyInsuranceCustomers set fullName = ?,fatherName = ?,phoneNumber = ?,homePhone = ?,address = ?,userType = ? where nationalId = ?");
        preparedStatement.setString(1,socialSupplyInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,socialSupplyInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(3,socialSupplyInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(4,socialSupplyInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(5,socialSupplyInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(6,socialSupplyInsuranceCustomersEntity.getUserType());
        preparedStatement.setString(7,socialSupplyInsuranceCustomersEntity.getNationalId());
        preparedStatement.executeUpdate();
    }

    public List<SocialSupplyInsuranceCustomersEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from SocialSupplyInsuranceCustomers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<SocialSupplyInsuranceCustomersEntity> socialSupplyInsuranceCustomersEntityList = new ArrayList<>();
        while(resultSet.next()) {
            SocialSupplyInsuranceCustomersEntity socialSupplyInsuranceCustomersEntity = new SocialSupplyInsuranceCustomersEntity();
            socialSupplyInsuranceCustomersEntity.setFullName(resultSet.getString("fullName"));
            socialSupplyInsuranceCustomersEntity.setNationalId(resultSet.getString("nationalId"));
            socialSupplyInsuranceCustomersEntity.setCertificateId(resultSet.getString("certificateId"));
            socialSupplyInsuranceCustomersEntity.setFatherName(resultSet.getString("fatherName"));
            socialSupplyInsuranceCustomersEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            socialSupplyInsuranceCustomersEntity.setHomePhone(resultSet.getString("homePhone"));
            socialSupplyInsuranceCustomersEntity.setBirthDate(resultSet.getString("birthDate"));
            socialSupplyInsuranceCustomersEntity.setAddress(resultSet.getString("address"));
            socialSupplyInsuranceCustomersEntity.setNationality(resultSet.getString("nationality"));
            socialSupplyInsuranceCustomersEntity.setUserType(resultSet.getString("userType"));
            socialSupplyInsuranceCustomersEntityList.add(socialSupplyInsuranceCustomersEntity);
        }
        return socialSupplyInsuranceCustomersEntityList;
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
