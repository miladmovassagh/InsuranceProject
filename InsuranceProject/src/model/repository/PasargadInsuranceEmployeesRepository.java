package model.repository;

import model.entity.PasargadInsuranceEmployeesEntity;

import java.sql.*;
import java.util.*;

public class PasargadInsuranceEmployeesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PasargadInsuranceEmployeesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(PasargadInsuranceEmployeesEntity pasargadInsuranceEmployeesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into PasargadInsuranceEmployees(fullName,username,password,nationalId,phoneNumber,homePhone,birthDate,address,email,education,studyField,maritalStatus,workExperience) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,pasargadInsuranceEmployeesEntity.getFullName());
        preparedStatement.setString(2,pasargadInsuranceEmployeesEntity.getUsername());
        preparedStatement.setString(3,pasargadInsuranceEmployeesEntity.getPassword());
        preparedStatement.setString(4,pasargadInsuranceEmployeesEntity.getNationalId());
        preparedStatement.setString(5,pasargadInsuranceEmployeesEntity.getPhoneNumber());
        preparedStatement.setString(6,pasargadInsuranceEmployeesEntity.getHomePhone());
        preparedStatement.setString(7,pasargadInsuranceEmployeesEntity.getBirthDate());
        preparedStatement.setString(8,pasargadInsuranceEmployeesEntity.getAddress());
        preparedStatement.setString(9,pasargadInsuranceEmployeesEntity.getEmail());
        preparedStatement.setString(10,pasargadInsuranceEmployeesEntity.getEducation());
        preparedStatement.setString(11,pasargadInsuranceEmployeesEntity.getStudyField());
        preparedStatement.setString(12,pasargadInsuranceEmployeesEntity.getMaritalStatus());
        preparedStatement.setInt(13,pasargadInsuranceEmployeesEntity.getWorkExperience());
        preparedStatement.executeUpdate();
    }

    public List<PasargadInsuranceEmployeesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from PasargadInsuranceEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PasargadInsuranceEmployeesEntity> pasargadInsuranceEmployeesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            PasargadInsuranceEmployeesEntity pasargadInsuranceEmployeesEntity = new PasargadInsuranceEmployeesEntity();
            pasargadInsuranceEmployeesEntity.setFullName(resultSet.getString("fullName"));
            pasargadInsuranceEmployeesEntity.setUsername(resultSet.getString("username"));
            pasargadInsuranceEmployeesEntity.setPassword(resultSet.getString("password"));
            pasargadInsuranceEmployeesEntity.setNationalId(resultSet.getString("nationalId"));
            pasargadInsuranceEmployeesEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            pasargadInsuranceEmployeesEntity.setHomePhone(resultSet.getString("homePhone"));
            pasargadInsuranceEmployeesEntity.setBirthDate(resultSet.getString("birthDate"));
            pasargadInsuranceEmployeesEntity.setAddress(resultSet.getString("address"));
            pasargadInsuranceEmployeesEntity.setEmail(resultSet.getString("email"));
            pasargadInsuranceEmployeesEntity.setEducation(resultSet.getString("education"));
            pasargadInsuranceEmployeesEntity.setStudyField(resultSet.getString("studyField"));
            pasargadInsuranceEmployeesEntity.setMaritalStatus(resultSet.getString("maritalStatus"));
            pasargadInsuranceEmployeesEntity.setWorkExperience(resultSet.getInt("workExperience"));
            pasargadInsuranceEmployeesEntityList.add(pasargadInsuranceEmployeesEntity);
        }
        return pasargadInsuranceEmployeesEntityList;
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
