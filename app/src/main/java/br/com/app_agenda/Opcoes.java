package br.com.app_agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Opcoes extends AppCompatActivity {

    Button btnListaContatos, btnNovaAgenda;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcoes);
        initialize();

        btnListaContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callListContactView();
            }
        });

        btnNovaAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNovaAgenda();
            }
        });


    }

    public void callListContactView() {
        Intent intent = new Intent(this, ContactListView.class);
        startActivity(intent);
    }

    public void callNovaAgenda() {
        Intent intent = new Intent(this, NovaAgenda.class);
        startActivity(intent);
    }

    public void initialize() {
        btnListaContatos = findViewById(R.id.btn_lista_de_contato);
        btnNovaAgenda = findViewById(R.id.btn_novo_contato);
    }
}
