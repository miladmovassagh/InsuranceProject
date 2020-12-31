package model.repository;

import model.entity.ParsianInsuranceEmployeesEntity;

import java.sql.*;
import java.util.*;

public class ParsianInsuranceEmployeesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ParsianInsuranceEmployeesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(ParsianInsuranceEmployeesEntity parsianInsuranceEmployeesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into ParsianInsuranceEmployees(fullName,username,password,nationalId,phoneNumber,homePhone,birthDate,address,email,education,studyField,maritalStatus,workExperience) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,parsianInsuranceEmployeesEntity.getFullName());
        preparedStatement.setString(2,parsianInsuranceEmployeesEntity.getUsername());
        preparedStatement.setString(3,parsianInsuranceEmployeesEntity.getPassword());
        preparedStatement.setString(4,parsianInsuranceEmployeesEntity.getNationalId());
        preparedStatement.setString(5,parsianInsuranceEmployeesEntity.getPhoneNumber());
        preparedStatement.setString(6,parsianInsuranceEmployeesEntity.getHomePhone());
        preparedStatement.setString(7,parsianInsuranceEmployeesEntity.getBirthDate());
        preparedStatement.setString(8,parsianInsuranceEmployeesEntity.getAddress());
        preparedStatement.setString(9,parsianInsuranceEmployeesEntity.getEmail());
        preparedStatement.setString(10,parsianInsuranceEmployeesEntity.getEducation());
        preparedStatement.setString(11,parsianInsuranceEmployeesEntity.getStudyField());
        preparedStatement.setString(12,parsianInsuranceEmployeesEntity.getMaritalStatus());
        preparedStatement.setInt(13,parsianInsuranceEmployeesEntity.getWorkExperience());
        preparedStatement.executeUpdate();
    }

    public List<ParsianInsuranceEmployeesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from ParsianInsuranceEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ParsianInsuranceEmployeesEntity> parsianInsuranceEmployeesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            ParsianInsuranceEmployeesEntity parsianInsuranceEmployeesEntity = new ParsianInsuranceEmployeesEntity();
            parsianInsuranceEmployeesEntity.setFullName(resultSet.getString("fullName"));
            parsianInsuranceEmployeesEntity.setUsername(resultSet.getString("username"));
            parsianInsuranceEmployeesEntity.setPassword(resultSet.getString("password"));
            parsianInsuranceEmployeesEntity.setNationalId(resultSet.getString("nationalId"));
            parsianInsuranceEmployeesEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            parsianInsuranceEmployeesEntity.setHomePhone(resultSet.getString("homePhone"));
            parsianInsuranceEmployeesEntity.setBirthDate(resultSet.getString("birthDate"));
            parsianInsuranceEmployeesEntity.setAddress(resultSet.getString("address"));
            parsianInsuranceEmployeesEntity.setEmail(resultSet.getString("email"));
            parsianInsuranceEmployeesEntity.setEducation(resultSet.getString("education"));
            parsianInsuranceEmployeesEntity.setStudyField(resultSet.getString("studyField"));
            parsianInsuranceEmployeesEntity.setMaritalStatus(resultSet.getString("maritalStatus"));
            parsianInsuranceEmployeesEntity.setWorkExperience(resultSet.getInt("workExperience"));
            parsianInsuranceEmployeesEntityList.add(parsianInsuranceEmployeesEntity);
        }
        return parsianInsuranceEmployeesEntityList;
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
