package csu.web.petstore.persistence.impl;

import csu.web.petstore.domain.Account;
import csu.web.petstore.persistence.AccountDao;
import csu.web.petstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements AccountDao {

    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT " +
            "SIGNON.USERNAME," +
            "ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS," +
            "ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2," +
            "ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE," +
            "PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId," +
            "PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption," +
            "BANNERDATA.BANNERNAME " +
            "FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA " +
            "WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ? " +
            "AND SIGNON.USERNAME = ACCOUNT.USERID " +
            "AND PROFILE.USERID = ACCOUNT.USERID " +
            "AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    @Override
    public Account getAccountByUsername(String username) {
        return null;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account accountResult = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                accountResult = this.resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return accountResult;
    }

    private Account resultSetToAccount(ResultSet resultSet) throws Exception{
        Account account = new Account();
        account.setUsername(resultSet.getString("username"));
//        account.setPassword(resultSet.getString("password"));
        account.setEmail(resultSet.getString("email"));
        account.setFirstName(resultSet.getString("firstName"));
        account.setLastName(resultSet.getString("lastName"));
        account.setStatus(resultSet.getString("status"));
        account.setAddress1(resultSet.getString("address1"));
        account.setAddress2(resultSet.getString("address2"));
        account.setCity(resultSet.getString("city"));
        account.setState(resultSet.getString("state"));
        account.setZip(resultSet.getString("zip"));
        account.setCountry(resultSet.getString("country"));
        account.setPhone(resultSet.getString("phone"));
        account.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
        account.setLanguagePreference(resultSet.getString("languagePreference"));
        account.setListOption(resultSet.getInt("listOption") == 1);
        account.setBannerOption(resultSet.getInt("bannerOption") == 1);
        account.setBannerName(resultSet.getString("bannerName"));
        return account;
    }

    @Override
    public void insertAccount(Account account) {




    }

    @Override
    public void insertProfile(Account account) {



    }

    @Override
    public void insertSignon(Account account) {
        String INSERT_ACCOUNT= "INSERT INTO signon(username,password) values('"+account.getUsername()+"','"+account.getPassword()+"')";
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);

            ResultSet resultSet = preparedStatement.executeQuery();

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void updateProfile(Account account) {
        String INSERT_Profile="update account set firstname='"+account.getFirstName()+"',lastname='"+account.getLastName()+"'" +
                ",addr1='"+account.getAddress1()+"',addr2='"+account.getAddress2()+"',city='"+account.getCity()+"',state='"+account.getState()+"'" +
                ",country='"+account.getCountry()+"',phone='"+account.getPhone()+"'"+" where userid='"+account.getUsername()+"'";
        System.out.println(INSERT_Profile);
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Profile);

            int resultSet = preparedStatement.executeUpdate();


            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateSignon(Account account) {

    }

//    public static void main(String[] args) {
//        AccountDao accountDao = new AccountDaoImpl();
//        Account account = new Account();
//        account.setUsername("j2ee");
//        account.setPassword("jee");
//        Account result = accountDao.getAccountByUsernameAndPassword(account);
//        System.out.println("success");
//    }
}
