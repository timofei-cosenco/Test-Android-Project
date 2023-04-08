package com.arhiser.todolist.screens.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.arhiser.todolist.App;
import com.arhiser.todolist.R;
import com.arhiser.todolist.data.UserDao;
import com.arhiser.todolist.model.User;

public class MainActivity extends AppCompatActivity {

    private String login, password;
    private User user = new User("tipao", "143XD77m1");
    private UserDao userDao = App.getInstance().getUserDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDao.insert(user);
        setContentView(R.layout.login_page);
        EditText editText1 = findViewById(R.id.login);
        EditText editText2 = findViewById(R.id.password);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length() == 0){
                    login = " ";
                }
                else{
                    login = charSequence.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length() == 0){
                    password = " ";
                }
                else{
                    password = charSequence.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void loginApp(View view){
        TextView textView = findViewById(R.id.warning);
        if (login !=null & password !=null) {
            User user = userDao.findByName(login, password);
            if(user != null) {
                Intent intent = new Intent(this, MainPageActivity.class);
                startActivity(intent);
            }
        }
        else {
            textView.setText("Error");
        }
    }

}
