package model.repository;

import model.entity.IranInsuranceCustomersEntity;

import java.sql.*;
import java.util.*;

public class IranInsuranceCustomersRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public IranInsuranceCustomersRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(IranInsuranceCustomersEntity iranInsuranceCustomersEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into IranInsuranceCustomers(fullName,nationalId,certificateId,fatherName,phoneNumber,homePhone,birthDate,address,nationality,userType) values (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,iranInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,iranInsuranceCustomersEntity.getNationalId());
        preparedStatement.setString(3,iranInsuranceCustomersEntity.getCertificateId());
        preparedStatement.setString(4,iranInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(5,iranInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(6,iranInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(7,iranInsuranceCustomersEntity.getBirthDate());
        preparedStatement.setString(8,iranInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(9,iranInsuranceCustomersEntity.getNationality());
        preparedStatement.setString(10,iranInsuranceCustomersEntity.getUserType());
        preparedStatement.executeUpdate();
    }

    public void update(IranInsuranceCustomersEntity iranInsuranceCustomersEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update IranInsuranceCustomers set fullName = ?,fatherName = ?,phoneNumber = ?,homePhone = ?,address = ?,userType = ? where nationalId = ?");
        preparedStatement.setString(1,iranInsuranceCustomersEntity.getFullName());
        preparedStatement.setString(2,iranInsuranceCustomersEntity.getFatherName());
        preparedStatement.setString(3,iranInsuranceCustomersEntity.getPhoneNumber());
        preparedStatement.setString(4,iranInsuranceCustomersEntity.getHomePhone());
        preparedStatement.setString(5,iranInsuranceCustomersEntity.getAddress());
        preparedStatement.setString(6,iranInsuranceCustomersEntity.getUserType());
        preparedStatement.setString(7,iranInsuranceCustomersEntity.getNationalId());
        preparedStatement.executeUpdate();
    }

    public List<IranInsuranceCustomersEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from IranInsuranceCustomers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<IranInsuranceCustomersEntity> iranInsuranceCustomersEntityList = new ArrayList<>();
        while(resultSet.next()) {
            IranInsuranceCustomersEntity iranInsuranceCustomersEntity = new IranInsuranceCustomersEntity();
            iranInsuranceCustomersEntity.setFullName(resultSet.getString("fullName"));
            iranInsuranceCustomersEntity.setNationalId(resultSet.getString("nationalId"));
            iranInsuranceCustomersEntity.setCertificateId(resultSet.getString("certificateId"));
            iranInsuranceCustomersEntity.setFatherName(resultSet.getString("fatherName"));
            iranInsuranceCustomersEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            iranInsuranceCustomersEntity.setHomePhone(resultSet.getString("homePhone"));
            iranInsuranceCustomersEntity.setBirthDate(resultSet.getString("birthDate"));
            iranInsuranceCustomersEntity.setAddress(resultSet.getString("address"));
            iranInsuranceCustomersEntity.setNationality(resultSet.getString("nationality"));
            iranInsuranceCustomersEntity.setUserType(resultSet.getString("userType"));
            iranInsuranceCustomersEntityList.add(iranInsuranceCustomersEntity);
        }
        return iranInsuranceCustomersEntityList;
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
