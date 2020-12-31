package model.repository;

import model.entity.IranInsuranceEmployeesEntity;

import java.sql.*;
import java.util.*;

public class IranInsuranceEmployeesRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public IranInsuranceEmployeesRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(IranInsuranceEmployeesEntity iranInsuranceEmployeesEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into IranInsuranceEmployees(fullName,username,password,nationalId,phoneNumber,homePhone,birthDate,address,email,education,studyField,maritalStatus,workExperience) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,iranInsuranceEmployeesEntity.getFullName());
        preparedStatement.setString(2,iranInsuranceEmployeesEntity.getUsername());
        preparedStatement.setString(3,iranInsuranceEmployeesEntity.getPassword());
        preparedStatement.setString(4,iranInsuranceEmployeesEntity.getNationalId());
        preparedStatement.setString(5,iranInsuranceEmployeesEntity.getPhoneNumber());
        preparedStatement.setString(6,iranInsuranceEmployeesEntity.getHomePhone());
        preparedStatement.setString(7,iranInsuranceEmployeesEntity.getBirthDate());
        preparedStatement.setString(8,iranInsuranceEmployeesEntity.getAddress());
        preparedStatement.setString(9,iranInsuranceEmployeesEntity.getEmail());
        preparedStatement.setString(10,iranInsuranceEmployeesEntity.getEducation());
        preparedStatement.setString(11,iranInsuranceEmployeesEntity.getStudyField());
        preparedStatement.setString(12,iranInsuranceEmployeesEntity.getMaritalStatus());
        preparedStatement.setInt(13,iranInsuranceEmployeesEntity.getWorkExperience());
        preparedStatement.executeUpdate();
    }

    public List<IranInsuranceEmployeesEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from IranInsuranceEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<IranInsuranceEmployeesEntity> iranInsuranceEmployeesEntityList = new ArrayList<>();
        while(resultSet.next()) {
            IranInsuranceEmployeesEntity iranInsuranceEmployeesEntity = new IranInsuranceEmployeesEntity();
            iranInsuranceEmployeesEntity.setFullName(resultSet.getString("fullName"));
            iranInsuranceEmployeesEntity.setUsername(resultSet.getString("username"));
            iranInsuranceEmployeesEntity.setPassword(resultSet.getString("password"));
            iranInsuranceEmployeesEntity.setNationalId(resultSet.getString("nationalId"));
            iranInsuranceEmployeesEntity.setPhoneNumber(resultSet.getString("phoneNumber"));
            iranInsuranceEmployeesEntity.setHomePhone(resultSet.getString("homePhone"));
            iranInsuranceEmployeesEntity.setBirthDate(resultSet.getString("birthDate"));
            iranInsuranceEmployeesEntity.setAddress(resultSet.getString("address"));
            iranInsuranceEmployeesEntity.setEmail(resultSet.getString("email"));
            iranInsuranceEmployeesEntity.setEducation(resultSet.getString("education"));
            iranInsuranceEmployeesEntity.setStudyField(resultSet.getString("studyField"));
            iranInsuranceEmployeesEntity.setMaritalStatus(resultSet.getString("maritalStatus"));
            iranInsuranceEmployeesEntity.setWorkExperience(resultSet.getInt("workExperience"));
            iranInsuranceEmployeesEntityList.add(iranInsuranceEmployeesEntity);
        }
        return iranInsuranceEmployeesEntityList;
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
