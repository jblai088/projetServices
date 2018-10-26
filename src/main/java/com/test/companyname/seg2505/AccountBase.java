package com.test.companyname.seg2505;

public class AccountBase {
    public enum Type {
        admin,four,prop
    };

    private String username;
    private String password;
    private Type type;

    public AccountBase(String username, String password, Type type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getTypeName() {
        switch (type) {
            case admin: return "Administrateur";
            case four: return "Fournisseur";
            case prop: return "Propriétaire";
            default: return "ERROR";
        }
    }

    public boolean passwordMatch(String password) {
        return this.password.equals(password);
    }
}
