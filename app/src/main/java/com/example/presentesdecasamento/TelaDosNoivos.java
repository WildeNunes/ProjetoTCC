package com.example.presentesdecasamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TelaDosNoivos extends AppCompatActivity{

    EditText senha;
    TextView SenhaInvalida;
    Button botSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dos_noivos);

        senha = (EditText) findViewById(R.id.senha);
        SenhaInvalida = (TextView) findViewById(R.id.SenhaInvalida);
        botSenha = (Button) findViewById(R.id.botSenha);

        botSenha.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int Digito = Integer.parseInt(senha.getText().toString());
                if (Digito == 1234) {
                    Intent intent2 = new Intent(getApplicationContext(), BancoDeDados.class);
                    startActivity(intent2);
                    SenhaInvalida.setText(" ");
                } else {
                    SenhaInvalida.setText("Senha Invalida");
                }
            }
        });
    }
}