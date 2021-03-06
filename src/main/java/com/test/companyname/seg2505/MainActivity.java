package com.test.companyname.seg2505;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void homepage(AccountBase currentAccount) {
        setContentView(R.layout.activity_homepage);
        TextView welcome = findViewById(R.id.welcomeMessage);
        TextView type = findViewById(R.id.typeMessage);
        welcome.setText(getResources().getString(R.string.welcome_name,currentAccount.getUsername()));
        type.setText(currentAccount.getTypeName());
    }

    public void onLogin(View view) {
        String username = findViewById(R.id.usernameText).toString();
        String password = findViewById(R.id.passwordText).toString();
        AccountBase account = Database.getDatabase().getAccount(username);
        if (account!=null && account.passwordMatch(password))
            homepage(account);
    }

    public void onCreate(View view) {
        setContentView(R.layout.activity_createaccount);
    }

    public void onCreateConfirm(View view) {
        String username = findViewById(R.id.createUsername).toString();
        String password = findViewById(R.id.createPassword).toString();
        try {
            if (password.equals(findViewById(R.id.createPassword2).toString())) {
                AccountBase.Type type = getAccountType(username);
                AccountBase account = Database.getDatabase().createAccount(username, password, type);
                homepage(account);
            } else throw new IllegalArgumentException("Password mismatch");
        } catch (IllegalArgumentException e) {
            //Message d'erreur
        }
    }

    private AccountBase.Type getAccountType(String username) throws IllegalArgumentException {
        if (username.equals("admin")) return AccountBase.Type.admin;
        RadioButton fourButton = findViewById(R.id.radioButtonFour);
        RadioButton propButton = findViewById(R.id.radioButtonProp);
        if (fourButton.isChecked())
            return AccountBase.Type.four;
        if (propButton.isChecked())
            return AccountBase.Type.prop;
        throw new IllegalArgumentException("No type selected");
    }
}
