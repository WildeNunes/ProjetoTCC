package com.example.presentesdecasamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button botTela;
    EditText NumCPF;
    TextView Erro;
    EditText NomUsu;
    static int envi;
    static String envi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumCPF = (EditText) findViewById(R.id.NumCPF);
        botTela = findViewById(R.id.botTela);
        Erro = (TextView) findViewById(R.id.Erro);
        NomUsu = (EditText) findViewById(R.id.NomUsu);

        botTela.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                int cpf = Integer.parseInt(NumCPF.getText().toString());
                envi = cpf;
                String nome = String.valueOf(NomUsu.getText().toString());
                envi2 = nome;

                if(NomUsu.getText().toString().equals("")){
                    Erro.setText("Op's Esqueceu o Nome!");
                }
                else if (cpf != 12345 && cpf != 54321 && cpf > 9999 && cpf < 100000 ) {
                    Intent intent = new Intent (MainActivity.this, OutraTela.class);
                    startActivity(intent);
                    finish();
                }
                else if (cpf == 12345 || cpf == 54321 && cpf > 9999 && cpf < 100000){
                    Intent intent2 = new Intent (MainActivity.this, TelaSenha.class);
                    startActivity(intent2);
                }
                else {
                    Erro.setText("Op's CPF Invalido!");
                }
            }
        });
    }
}