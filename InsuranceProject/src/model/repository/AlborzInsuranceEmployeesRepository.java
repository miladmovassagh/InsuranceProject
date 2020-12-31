package model.repository;

import model.entity.AlborzInsuranceEmployeesEntity;

import java.sql.*;
import java.util.*;

public class AlborzInsuranceEmployeesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public AlborzInsuranceEmployeesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(AlborzInsuranceEmployeesEntity alborzInsuranceEmployeesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into AlborzInsuranceEmployees(fullName,username,password,nationalId,phoneNumber,homePhone,birthDate,address,email,education,studyField,maritalStatus,workExperience) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,alborzInsuranceEmployeesEntity.getFullName());
        preparedStatement.setString(2,alborzInsuranceEmployeesEntity.getUsername());
        preparedStatement.setString(3,alborzInsuranceEmployeesEntity.getPassword());
        preparedStatement.setString(4,alborzInsuranceEmployeesEntity.getNationalId());
        preparedStatement.setString(5,alborzInsuranceEmployeesEntity.getPhoneNumber());
        preparedStatement.setString(6,alborzInsuranceEmployeesEntity.getHomePhone());
        preparedStatement.setString(7,alborzInsuranceEmployeesEntity.getBirthDate());
        preparedStatement.setString(8,alborzInsuranceEmployeesEntity.getAddress());
        preparedStatement.setString(9,alborzInsuranceEmployeesEntity.getEmail());
        preparedStatement.setString(10,alborzInsuranceEmployeesEntity.getEducation());
        preparedStatement.setString(11,alborzInsuranceEmployeesEntity.getStudyField());
        preparedStatement.setString(12,alborzInsuranceEmployeesEntity.getMaritalStatus());
        preparedStatement.setInt(13,alborzInsuranceEmployeesEntity.getWorkExperience());
        preparedStatement.executeUpdate();
    }

    public List<AlborzInsuranceEmployeesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from AlborzInsuranceEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<AlborzInsuranceEmployeesEntity> alborzInsuranceEmployeesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            AlborzInsuranceEmployeesEntity alborzInsuranceEmployeesEntity = new AlborzInsuranceEmployeesEntity();
            alborzInsuranceEmployeesEntity.setFullName(resultSet.getString("fullName"));
            alborzInsuranceEmployeesEntity.setUsername(resultSet.getString("username"));
            alborzInsuranceEmployeesEntity.setPassword(resultSet.getString("password"));
            alborzInsuranceEmployeesEntity.setNationalId(resultSet.getString("nationalId"));
            alborzInsuranceEmployeesEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            alborzInsuranceEmployeesEntity.setHomePhone(resultSet.getString("homePhone"));
            alborzInsuranceEmployeesEntity.setBirthDate(resultSet.getString("birthDate"));
            alborzInsuranceEmployeesEntity.setAddress(resultSet.getString("address"));
            alborzInsuranceEmployeesEntity.setEmail(resultSet.getString("email"));
            alborzInsuranceEmployeesEntity.setEducation(resultSet.getString("education"));
            alborzInsuranceEmployeesEntity.setStudyField(resultSet.getString("studyField"));
            alborzInsuranceEmployeesEntity.setMaritalStatus(resultSet.getString("maritalStatus"));
            alborzInsuranceEmployeesEntity.setWorkExperience(resultSet.getInt("workExperience"));
            alborzInsuranceEmployeesEntityList.add(alborzInsuranceEmployeesEntity);
        }
        return alborzInsuranceEmployeesEntityList;
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