package com.test.companyname.seg2505;

import java.util.HashMap;

public class Database {
    private static Database singleton;

    public static Database getDatabase() {
        return singleton;
    }

    private HashMap<String,AccountBase> map;
    private boolean hasAdmin = false;

    public Database() {
        map = new HashMap<String,AccountBase>();
    }

    public AccountBase getAccount(String name) {
        return map.get(name);
    }

    public AccountBase createAccount(String username, String password, AccountBase.Type type) {
        if (map.containsKey(username))
            return null;
        else {
            if (type == AccountBase.Type.admin) {
                if (hasAdmin)
                    return null;
                hasAdmin = true;
            }
            AccountBase account = new AccountBase(username,password,type);
            map.put(username,account);
            return account;
        }
    }

}
