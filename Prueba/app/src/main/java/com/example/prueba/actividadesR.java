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
import android.widget.RadioButton;

import java.util.ArrayList;

public class actividadesR extends AppCompatActivity {

    private String estado;

    private ArrayList<String> actividades;
    private ArrayAdapter<String> adaptador1;
    private ListView lv1;
    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_r);
        actividades=new ArrayList<String>();
        actividades.add("Dormir Estado: Por Realizar");
        actividades.add("Comer Estado: Realizado");

        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,actividades);
        lv1=(ListView)findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);

        et1=(EditText)findViewById(R.id.edt1);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(actividadesR.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este número de teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        actividades.remove(posicion);
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

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // hacemos un case con lo que ocurre cada vez que pulsemos un botón

        switch (view.getId()) {
            case R.id.radioButton:
                if (checked) {
                    estado = "por realizar";
                    System.out.println("La actividad es: por realizar");
                }
                //
                break;
            case R.id.radioButton2:
                if (checked) {
                    estado = "Realizando";
                    System.out.println("La actividad es: realizando");
                }
                //
                break;
            case R.id.radioButton3:
                if (checked) {
                    estado = "Realizado";
                    System.out.println("La actividad es: realizado");
                }
                //
                break;
        }
    }
    public void agregar(View v) {
        if(et1.getText().toString().equals("")){
            System.out.println("Ingrese el nombre y número de télefono!");
            String titulo = "No se puede guardar";
            String mensajeAlerta= "Debe ingresar un nombre y número de teléfono para guardar.";
        }else {
            actividades.add(et1.getText().toString()+" Estdo: "+estado);
            adaptador1.notifyDataSetChanged();
            et1.setText("");
        }
    }

}
