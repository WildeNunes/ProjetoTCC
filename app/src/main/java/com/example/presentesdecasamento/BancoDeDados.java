package com.example.presentesdecasamento;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados extends AppCompatActivity{

    public int  variavel1;
    public String variavel2;
    String variavel3;
    public float variavel4 = (float) 123.4;

    TextView text,errorText, texto3;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banco_de_dados);

        OutraTela imp = new OutraTela();
        variavel3 = imp.envi3;
        variavel4 = imp.envi4;

        MainActivity imp2 = new MainActivity();
        variavel1 = imp2.envi;
        variavel2 = imp2.envi2;

        text = (TextView) findViewById(R.id.texto1);

        errorText = (TextView) findViewById(R.id.texto2);

        texto3 = (TextView) findViewById(R.id.texto3);


        if(variavel1 == 12345 || variavel1 == 54321) {

                    new ListarPresentes().execute();

        } else if(variavel1 != 12345 && variavel1 != 54321) {

                    new InserirDados().execute();
        }
    }

    class InserirDados extends AsyncTask<Void, Void, Void> {

        String records = "",error="";

        @Override

        protected Void doInBackground(Void... voids) {

            try

            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://34.173.22.43:3306/presentes", "root", "wd18790282");
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO lista (cpf, nome, presente, preco) VALUES ('"+ variavel1 +"','"+ variavel2 +"','"+ variavel3 +"','"+ variavel4 +"')";

                statement.executeUpdate(sql);

                TextView texto = findViewById(R.id.texto3);
                texto.setText("Obrigado   pela   participação!   Agora   abra   o   aplicativo   de   seu   banco   " +
                        "e   cole   no   campo   pagamento   via   PIX!   " +
                        "Os   noivos   agora   vão   saber   que   voce   os   presenteou!   Até   breve!");



            }

            catch(Exception e)

            {

                error = e.toString();

            }

            return null;

        }

        @Override

        protected void onPostExecute(Void aVoid) {

            text.setText(records);

            if(error != "")

                errorText.setText(error);

            super.onPostExecute(aVoid);

        }

    }
    class ListarPresentes extends AsyncTask<Void, Void, Void> {

        String records = "",error="";

        @Override

        protected Void doInBackground(Void... voids) {

            try

            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://34.173.22.43:3306/presentes", "root", "wd18790282");
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT *FROM lista");

                while(resultSet.next()) {

                    records += "\nCPF: " + resultSet.getInt(1) + " NOME: " + resultSet.getString(2) + " PRESENTE: " + resultSet.getString(3) + " VALOR: " + resultSet.getFloat(4) + "\n";

                }

            }

            catch(Exception e)

            {

                error = e.toString();

            }

            return null;

        }

        @Override

        protected void onPostExecute(Void aVoid) {

            text.setText(records);

            if(error != "")

                errorText.setText(error);

            super.onPostExecute(aVoid);

        }

    }


}