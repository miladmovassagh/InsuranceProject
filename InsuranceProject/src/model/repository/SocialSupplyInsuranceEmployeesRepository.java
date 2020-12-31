package model.repository;

import model.entity.SocialSupplyInsuranceEmployeesEntity;

import java.sql.*;
import java.util.*;

public class SocialSupplyInsuranceEmployeesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public SocialSupplyInsuranceEmployeesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(SocialSupplyInsuranceEmployeesEntity socialSupplyInsuranceEmployeesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into SocialSupplyInsuranceEmployees(fullName,username,password,nationalId,phoneNumber,homePhone,birthDate,address,email,education,studyField,maritalStatus,workExperience) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,socialSupplyInsuranceEmployeesEntity.getFullName());
        preparedStatement.setString(2,socialSupplyInsuranceEmployeesEntity.getUsername());
        preparedStatement.setString(3,socialSupplyInsuranceEmployeesEntity.getPassword());
        preparedStatement.setString(4,socialSupplyInsuranceEmployeesEntity.getNationalId());
        preparedStatement.setString(5,socialSupplyInsuranceEmployeesEntity.getPhoneNumber());
        preparedStatement.setString(6,socialSupplyInsuranceEmployeesEntity.getHomePhone());
        preparedStatement.setString(7,socialSupplyInsuranceEmployeesEntity.getBirthDate());
        preparedStatement.setString(8,socialSupplyInsuranceEmployeesEntity.getAddress());
        preparedStatement.setString(9,socialSupplyInsuranceEmployeesEntity.getEmail());
        preparedStatement.setString(10,socialSupplyInsuranceEmployeesEntity.getEducation());
        preparedStatement.setString(11,socialSupplyInsuranceEmployeesEntity.getStudyField());
        preparedStatement.setString(12,socialSupplyInsuranceEmployeesEntity.getMaritalStatus());
        preparedStatement.setInt(13,socialSupplyInsuranceEmployeesEntity.getWorkExperience());
        preparedStatement.executeUpdate();
    }

    public List<SocialSupplyInsuranceEmployeesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from SocialSupplyInsuranceEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<SocialSupplyInsuranceEmployeesEntity> socialSupplyInsuranceEmployeesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            SocialSupplyInsuranceEmployeesEntity socialSupplyInsuranceEmployeesEntity = new SocialSupplyInsuranceEmployeesEntity();
            socialSupplyInsuranceEmployeesEntity.setFullName(resultSet.getString("fullName"));
            socialSupplyInsuranceEmployeesEntity.setUsername(resultSet.getString("username"));
            socialSupplyInsuranceEmployeesEntity.setPassword(resultSet.getString("password"));
            socialSupplyInsuranceEmployeesEntity.setNationalId(resultSet.getString("nationalId"));
            socialSupplyInsuranceEmployeesEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            socialSupplyInsuranceEmployeesEntity.setHomePhone(resultSet.getString("homePhone"));
            socialSupplyInsuranceEmployeesEntity.setBirthDate(resultSet.getString("birthDate"));
            socialSupplyInsuranceEmployeesEntity.setAddress(resultSet.getString("address"));
            socialSupplyInsuranceEmployeesEntity.setEmail(resultSet.getString("email"));
            socialSupplyInsuranceEmployeesEntity.setEducation(resultSet.getString("education"));
            socialSupplyInsuranceEmployeesEntity.setStudyField(resultSet.getString("studyField"));
            socialSupplyInsuranceEmployeesEntity.setMaritalStatus(resultSet.getString("maritalStatus"));
            socialSupplyInsuranceEmployeesEntity.setWorkExperience(resultSet.getInt("workExperience"));
            socialSupplyInsuranceEmployeesEntityList.add(socialSupplyInsuranceEmployeesEntity);
        }
        return socialSupplyInsuranceEmployeesEntityList;
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
