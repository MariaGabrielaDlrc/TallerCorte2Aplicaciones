package com.example.tallercorte2aplicaciones;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String dataUserCache = " ";
    private static final int modo_private = Context.MODE_PRIVATE;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button btnEnviar;
    EditText edtNombre, edtEdad;
    Spinner spCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(dataUserCache, modo_private);
        editor = sharedPreferences.edit();
        btnEnviar = findViewById(R.id.btnEnviar);
        edtNombre = findViewById(R.id.edtNombre);
        edtEdad = findViewById(R.id.edtEdad);
        spCategorias = findViewById(R.id.spnCategoria);
        String[] categorias = {"Cine", "Deportes", "Música"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categorias
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategorias.setAdapter(adapter);

        validarLogin();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = edtNombre.getText().toString();
                String edad = edtEdad.getText().toString();
                String categoria = spCategorias.getSelectedItem().toString();

                if (nombre.isEmpty() || edad.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else {

                    editor.putString("nombre", nombre);
                    editor.putString("edad", edad);
                    editor.putString("categoria", categoria);
                    editor.putString("user", nombre);
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, SegundaPantalla.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private void validarLogin() {
        String user = sharedPreferences.getString("user", "0");

        if (!user.equalsIgnoreCase("0")) {
            Intent i = new Intent(MainActivity.this, SegundaPantalla.class);
            startActivity(i);
            finish();
        }
    }
}
