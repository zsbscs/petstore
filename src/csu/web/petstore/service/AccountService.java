package csu.web.petstore.service;

import csu.web.petstore.domain.Account;
import csu.web.petstore.persistence.AccountDao;
import csu.web.petstore.persistence.impl.AccountDaoImpl;

public class AccountService {
    private AccountDao accountDao;

    public AccountService(){
        this.accountDao = new AccountDaoImpl();
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDao.getAccountByUsernameAndPassword(account);
    }
    public void InsertSignon(String username,String password){
            Account account=new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountDao.insertSignon(account);

    }
    public void UpdateProfile(Account account){

        accountDao.updateProfile(account);

    }








}
