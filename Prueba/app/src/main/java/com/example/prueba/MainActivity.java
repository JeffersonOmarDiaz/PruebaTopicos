package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.app.ComponentActivity.ExtraData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);final
        String user2="Omar";
        final String pasw ="1234";

        final Button boton = (Button) findViewById(R.id.btnLogin);
        boton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view){
                String usuario = ((EditText) findViewById(R.id.et1)).getText().toString();
                String password = ((EditText) findViewById(R.id.et2)).getText().toString();
                if (usuario.equals(user2) && password.equals(pasw)){
                    abrirAPP();
                }else{
                    Toast.makeText(boton.getContext(), "Usuario Incorrecto o clave incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void abrirAPP(){
        Intent nuevo = new Intent(this,actividadesR.class);
        startActivity(nuevo);
    }
    public void registro(View view){
        Intent nuevo = new Intent(this,registro.class);
        startActivity(nuevo);
    }

}
