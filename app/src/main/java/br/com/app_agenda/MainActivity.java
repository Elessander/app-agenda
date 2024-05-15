package br.com.app_agenda;

import static android.os.StrictMode.setThreadPolicy;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.HashMap;

import br.com.app_agenda.service.Message;
import br.com.app_agenda.service.Service;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
//    Funciona tipo o main do java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        initialize();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Bem vindo " + username.getText());
                efetuaLogin();
            }
        });
    }

    public void efetuaLogin() {
        Service service = new Service();
        HashMap<String, String> req = new HashMap<>();
        Log.i(null, "Pós instancia do hash map");
        req.put("username", username.getText().toString());
        req.put("password", password.getText().toString());
        Log.i(null, "pré post");
        String res = service.Post("login", req);
        Log.i(null,req.toString());
        Log.i(null,res);
        Gson gson = new Gson();
        Message msg = gson.fromJson(res, Message.class);

        if(msg.getAuth()) {
            Log.i(null, "Login Autorizado - Prox Tela" + msg.getMsg());
            Intent intent = new Intent(this, Opcoes.class);
            startActivity(intent);
        } else {
            Log.i(null, "Login não autorizado." + msg.getMsg());
        }
    }

    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void initialize() {
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        btnLogin = findViewById(R.id.login_btn);
    }
}