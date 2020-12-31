package model.repository;

import model.entity.AlborzInsuranceCustomersEntity;

import java.sql.*;
import java.util.*;

public class AlborzInsuranceCustomersRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public AlborzInsuranceCustomersRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(AlborzInsuranceCustomersEntity alborzInsuranceCustomersEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into AlborzInsuranceCustomers(fullName,nationalId,certificateId,fatherName,phoneNumber,homePhone,birthDate,address,nationality,userType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,alborzInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,alborzInsuranceCustomersEntity.getNationalId());
        preparedStatement.setString(3,alborzInsuranceCustomersEntity.getCertificateId());
        preparedStatement.setString(4,alborzInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(5,alborzInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(6,alborzInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(7,alborzInsuranceCustomersEntity.getBirthDate());
        preparedStatement.setString(8,alborzInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(9,alborzInsuranceCustomersEntity.getNationality());
        preparedStatement.setString(10,alborzInsuranceCustomersEntity.getUserType());
        preparedStatement.executeUpdate();
    }

    public void update(AlborzInsuranceCustomersEntity alborzInsuranceCustomersEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update AlborzInsuranceCustomers set fullName = ?,fatherName = ?,phoneNumber = ?,homePhone = ?,address = ?,userType = ? where nationalId = ?");
        preparedStatement.setString(1,alborzInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,alborzInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(3,alborzInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(4,alborzInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(5,alborzInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(6,alborzInsuranceCustomersEntity.getUserType());
        preparedStatement.setString(7,alborzInsuranceCustomersEntity.getNationalId());
        preparedStatement.executeUpdate();
    }

    public List<AlborzInsuranceCustomersEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from AlborzInsuranceCustomers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<AlborzInsuranceCustomersEntity> alborzInsuranceCustomersEntityList = new ArrayList<>();
        while(resultSet.next()) {
            AlborzInsuranceCustomersEntity alborzInsuranceCustomersEntity = new AlborzInsuranceCustomersEntity();
            alborzInsuranceCustomersEntity.setFullName(resultSet.getString("fullName"));
            alborzInsuranceCustomersEntity.setNationalId(resultSet.getString("nationalId"));
            alborzInsuranceCustomersEntity.setCertificateId(resultSet.getString("certificateId"));
            alborzInsuranceCustomersEntity.setFatherName(resultSet.getString("fatherName"));
            alborzInsuranceCustomersEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            alborzInsuranceCustomersEntity.setHomePhone(resultSet.getString("homePhone"));
            alborzInsuranceCustomersEntity.setBirthDate(resultSet.getString("birthDate"));
            alborzInsuranceCustomersEntity.setAddress(resultSet.getString("address"));
            alborzInsuranceCustomersEntity.setNationality(resultSet.getString("nationality"));
            alborzInsuranceCustomersEntity.setUserType(resultSet.getString("userType"));
            alborzInsuranceCustomersEntityList.add(alborzInsuranceCustomersEntity);
        }
        return alborzInsuranceCustomersEntityList;
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
