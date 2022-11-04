package com.example.presentesdecasamento;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class OutraTela extends AppCompatActivity {

    TextView text;
    Button Bot4;
    static String envi3;
    static float envi4;

    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra_tela);

        text = findViewById(R.id.text);
        Bot4 = findViewById(R.id.Bot4);

        Bot4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                if(text.getText().toString().equals("") || text.getText().toString().equals("Falta escolher o presente!")) {
                    TextView texto2 = findViewById(R.id.TextEdit2);
                    texto2.setText("Ops! Primeiro escolha o presente antes de prosseguir!");
                } else {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("EditText", text.getText().toString());
                    clipboard.setPrimaryClip(clip);

                    clip.getDescription();

                    Toast.makeText(OutraTela.this, "Copiado", Toast.LENGTH_SHORT).show();
                    Intent maisOutraTela = new Intent(getApplicationContext(), BancoDeDados.class);
                    startActivity(maisOutraTela);

                    Intent intent2 = new Intent(OutraTela.this, BancoDeDados.class);
                    finish();
                }
            }
        });
    }
    public void Bot1 (View v){

        TextView texto = findViewById(R.id.text);
        texto.setText("00020126360014BR.GOV.BCB.PIX0114+55119480009275204000053039865406180.005802BR5919WILDE PEREIRA NUNES6009SAO PAULO622605221amzs4pRjxBCM9ei5JEsrx6304DDF9");
        TextView texto2 = findViewById(R.id.TextEdit2);
        texto2.setText(" ");
        envi3 = "Cafeteira";
        envi4 = (float)180.00;
    }
    public void Bot2 (View v){

        TextView texto = findViewById(R.id.text);
        texto.setText("00020126360014BR.GOV.BCB.PIX0114+55119480009275204000053039865406771.005802BR5919WILDE PEREIRA NUNES6009SAO PAULO622605222aDhPLcQ7EKs3cLYlniN6S6304D2CE");
        TextView texto2 = findViewById(R.id.TextEdit2);
        texto2.setText(" ");
        envi3 = "Fogão";
        envi4 = (float)771.00;
    }
    public void Bot3 (View v) {

        TextView texto = findViewById(R.id.text);
        texto.setText("00020126360014BR.GOV.BCB.PIX0114+5511948000927520400005303986540525.005802BR5919WILDE PEREIRA NUNES6009SAO PAULO622605225508uTwiUyT65W7EY5X3V36304DBC5");
        TextView texto2 = findViewById(R.id.TextEdit2);
        texto2.setText(" ");
        envi3 = "Jarra";
        envi4 = (float)25.00;
    }
}