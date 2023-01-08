package com.example.tareadic1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    //listado de animales a mostrar
    private String[] animales = {"Perro", "Gato", "Caballo", "Pez"};
    private ImageView imagenGrande;
    private Switch autorizadorCambio;
    private Button botonCambioRojo;
    private Button botonCambioVerde;
    private ConstraintLayout pantallaPpal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // spinner asociado a los animales a mostrar.
        Spinner combo = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, animales);
        combo.setAdapter(adapter);

        // evento asociado al spinner, muestra en imageViewGrande el item seleccionado.
        // si no hay nada, muestra el primer item (perro) preseleccionado.
        // si el switch no está seleccionado no autoriza al cambio.

        imagenGrande = (ImageView) findViewById(R.id.imageViewGrande);
        autorizadorCambio = (Switch) findViewById(R.id.switch1);
        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (autorizadorCambio.isChecked()) {
                    if (combo.getSelectedItem().toString().equals("Perro")) {
                        imagenGrande.setImageResource(R.drawable.perro);
                    } else if (combo.getSelectedItem().toString().equals("Gato")) {
                        imagenGrande.setImageResource(R.drawable.gato);
                    } else if (combo.getSelectedItem().toString().equals("Caballo")) {
                        imagenGrande.setImageResource(R.drawable.caballo);
                    } else {
                        imagenGrande.setImageResource(R.drawable.pez);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                imagenGrande.setImageResource(R.drawable.animal_generico);
            }
        });

        // al pulsar el botónRojo se cambia el color de fondo de la aplicación a rojo
        botonCambioRojo = (Button) findViewById(R.id.botonRojo);
        pantallaPpal = (ConstraintLayout) findViewById(R.id.pantallaPrincipal);
        botonCambioRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaPpal.setBackgroundColor(Color.RED);
            }
        });

        botonCambioVerde = (Button) findViewById(R.id.botonVerde);
        pantallaPpal = (ConstraintLayout) findViewById(R.id.pantallaPrincipal);
        botonCambioVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaPpal.setBackgroundColor(Color.GREEN);
            }
        });



    }

}