package br.com.app_agenda;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import br.com.app_agenda.service.Service;


public class NovaAgenda extends AppCompatActivity {

    EditText nome, telefone, email, dataNascimento, descricao;

    Button btnSalvaAgenda;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_contato);
        initialize();

        btnSalvaAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });

    }

    public void addContact() {
        Service service = new Service();
        HashMap<String, String> req = new HashMap<>();
        req.put("contact", nome.getText().toString());
        req.put("phone", telefone.getText().toString());
        req.put("email", email.getText().toString());
        req.put("birthdate", dataNascimento.getText().toString());
        req.put("description", descricao.getText().toString());
        String res = service.Post("/addAgenda", req);
        Log.i(null, "Conver jason" + res.toString());
    }

    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void initialize() {
        nome = findViewById(R.id.nome_do_contato);
        telefone = findViewById(R.id.telefone_do_contato);
        email = findViewById(R.id.email_do_contato);
        dataNascimento = findViewById(R.id.nascimento_do_contato);
        descricao = findViewById(R.id.descricao_do_contato);
        btnSalvaAgenda = findViewById(R.id.btn_adiciona_contato);
    }

}
