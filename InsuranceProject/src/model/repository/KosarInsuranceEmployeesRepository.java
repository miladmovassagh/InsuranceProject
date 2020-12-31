package model.repository;

import model.entity.KosarInsuranceEmployeesEntity;

import java.sql.*;
import java.util.*;

public class KosarInsuranceEmployeesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public KosarInsuranceEmployeesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(KosarInsuranceEmployeesEntity kosarInsuranceEmployeesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into KosarInsuranceEmployees(fullName,username,password,nationalId,phoneNumber,homePhone,birthDate,address,email,education,studyField,maritalStatus,workExperience) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,kosarInsuranceEmployeesEntity.getFullName());
        preparedStatement.setString(2,kosarInsuranceEmployeesEntity.getUsername());
        preparedStatement.setString(3,kosarInsuranceEmployeesEntity.getPassword());
        preparedStatement.setString(4,kosarInsuranceEmployeesEntity.getNationalId());
        preparedStatement.setString(5,kosarInsuranceEmployeesEntity.getPhoneNumber());
        preparedStatement.setString(6,kosarInsuranceEmployeesEntity.getHomePhone());
        preparedStatement.setString(7,kosarInsuranceEmployeesEntity.getBirthDate());
        preparedStatement.setString(8,kosarInsuranceEmployeesEntity.getAddress());
        preparedStatement.setString(9,kosarInsuranceEmployeesEntity.getEmail());
        preparedStatement.setString(10,kosarInsuranceEmployeesEntity.getEducation());
        preparedStatement.setString(11,kosarInsuranceEmployeesEntity.getStudyField());
        preparedStatement.setString(12,kosarInsuranceEmployeesEntity.getMaritalStatus());
        preparedStatement.setInt(13,kosarInsuranceEmployeesEntity.getWorkExperience());
        preparedStatement.executeUpdate();
    }

    public List<KosarInsuranceEmployeesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from KosarInsuranceEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<KosarInsuranceEmployeesEntity> kosarInsuranceEmployeesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            KosarInsuranceEmployeesEntity kosarInsuranceEmployeesEntity = new KosarInsuranceEmployeesEntity();
            kosarInsuranceEmployeesEntity.setFullName(resultSet.getString("fullName"));
            kosarInsuranceEmployeesEntity.setUsername(resultSet.getString("username"));
            kosarInsuranceEmployeesEntity.setPassword(resultSet.getString("password"));
            kosarInsuranceEmployeesEntity.setNationalId(resultSet.getString("nationalId"));
            kosarInsuranceEmployeesEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            kosarInsuranceEmployeesEntity.setHomePhone(resultSet.getString("homePhone"));
            kosarInsuranceEmployeesEntity.setBirthDate(resultSet.getString("birthDate"));
            kosarInsuranceEmployeesEntity.setAddress(resultSet.getString("address"));
            kosarInsuranceEmployeesEntity.setEmail(resultSet.getString("email"));
            kosarInsuranceEmployeesEntity.setEducation(resultSet.getString("education"));
            kosarInsuranceEmployeesEntity.setStudyField(resultSet.getString("studyField"));
            kosarInsuranceEmployeesEntity.setMaritalStatus(resultSet.getString("maritalStatus"));
            kosarInsuranceEmployeesEntity.setWorkExperience(resultSet.getInt("workExperience"));
            kosarInsuranceEmployeesEntityList.add(kosarInsuranceEmployeesEntity);
        }
        return kosarInsuranceEmployeesEntityList;
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
