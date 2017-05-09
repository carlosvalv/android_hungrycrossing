package com.example.usuario.proyectodam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
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
