package com.example.usuario.proyectodam2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btLog;
    private EditText etUsername;
    private EditText etPssw;
    private String pass,username;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        btLog=(Button) (findViewById(R.id.btnLogin));
        btLog.setOnClickListener(this);

        etUsername=(EditText)(findViewById(R.id.etUsername));
        etPssw=(EditText)(findViewById(R.id.etPassword));


    }

    @Override
    public void onClick(View v) {
        if(v==btLog)
        {
            pass=etPssw.getText().toString();
            username=etUsername.getText().toString();
            URL url = null;
            try {
                url = new URL("http://hungrycrossing.000webhostapp/ComprobarLogin.php?nombre=" + username + "&pass=" + pass );
                HttpURLConnection urlConnection = null;
                urlConnection = (HttpURLConnection)url.openConnection();
                status = urlConnection.getResponseCode();


                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);

                urlConnection.setDoOutput(true);

                urlConnection.connect();

                BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

                char[] buffer = new char[1024];

                String jsonString = new String();

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();

                jsonString = sb.toString();

                System.out.println("JSON: " + jsonString);



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(status==1)//cas correcte
            {
                //pasem a la pagina principal

            }
            else
            {


            }


        }
    }
}
