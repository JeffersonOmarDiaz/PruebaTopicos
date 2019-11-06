package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class registro extends AppCompatActivity {

    public ArrayList<String> usuarios;
    private ArrayAdapter<String> adaptador1;
    private ListView lv1;
    private EditText txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuarios=new ArrayList<String>();
        usuarios.add("User1");
        usuarios.add("User2");

        System.out.println("Los usuarios son: "+usuarios.subList(0,1));

        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usuarios);
        lv1=(ListView)findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);

        txtUser=(EditText)findViewById(R.id.txtUser);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(registro.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este número de teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        usuarios.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();
                return false;
            }
        });
    }
    public void registra(View v) {
        if(txtUser.getText().toString().equals("")){
            System.out.println("Ingrese el nombre y número de télefono!");
            String titulo = "No se puede guardar";
            String mensajeAlerta= "Debe ingresar un nombre y número de teléfono para guardar.";
        }else {
            usuarios.add(txtUser.getText().toString());
            adaptador1.notifyDataSetChanged();
            txtUser.setText("");
        }
    }
}
