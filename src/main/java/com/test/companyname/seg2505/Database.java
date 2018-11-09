package com.test.companyname.seg2505;

import java.util.HashMap;

public class Database {
    private static Database singleton;

    public static Database getDatabase() {
        return singleton;
    }

    private Dataset<AccountBase> accountMap;
    private Dataset<Service> serviceMap;

    public AccountBase getAccount(String name) {
        return accountMap.get(name);
    }
    public Service getService(String name) { return serviceMap.get(name); }

    public AccountBase createAccount(String username, String password, AccountBase.Type type) throws IllegalArgumentException {
        AccountBase account = new AccountBase(username,password,type);
        if (!accountMap.create(username,account))
            throw new IllegalArgumentException("Account already exists.");
        return account;
    }

    public Service createService(String name, int hourRate) throws IllegalArgumentException {
        Service service = new Service(name,hourRate);
        if (!serviceMap.create(name,service))
            throw new IllegalArgumentException("Service already exists.");
        return service;
    }

}
