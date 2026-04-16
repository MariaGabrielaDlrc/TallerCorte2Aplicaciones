package com.example.tallercorte2aplicaciones;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class SegundaPantalla extends AppCompatActivity {

    public static final String dataUserCache = "UserCache";
    private static final int modo_private = Context.MODE_PRIVATE;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button btnRegresar;

    ImageView img1, img2, img3, img4, img5, img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        btnRegresar = findViewById(R.id.btnRegresar);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);


        sharedPreferences = getSharedPreferences(dataUserCache, modo_private);
        editor = sharedPreferences.edit();

        Picasso.get().load("https://i.pinimg.com/736x/a5/ad/78/a5ad7824ea7d474f4f1073999490e829.jpg").into(img1);
        Picasso.get().load("https://i.pinimg.com/736x/fa/aa/f9/faaaf91f05c09db3b10d3ca9cbe0aabf.jpg").into(img2);
        Picasso.get().load("https://i.pinimg.com/736x/f1/46/9b/f1469b0cb210fd209d925743a487ed16.jpg").into(img3);
        Picasso.get().load("https://i.pinimg.com/736x/98/52/34/9852345cc8ac88bd5c8138b2a252cf2a.jpg").into(img4);
        Picasso.get().load("https://i.pinimg.com/736x/83/6b/52/836b52f6775dc925c5dabe24e98e3403.jpg").into(img5);
        Picasso.get().load("https://i.pinimg.com/1200x/bd/b0/08/bdb0089d1db7c8757b75f68245fbfe93.jpg").into(img6);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarsesion();
            }
        });
    }

    private void cerrarsesion() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(SegundaPantalla.this, MainActivity.class);
        startActivity(i);

        finish();
    }
}