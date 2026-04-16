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

public class TerceraPantalla extends AppCompatActivity {

    public static final String dataUserCache = "UserCache";
    private static final int modo_private = Context.MODE_PRIVATE;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button btnRegresar;

    ImageView img1, img2, img3, img4, img5, img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_pantalla);

        btnRegresar = findViewById(R.id.btnRegresar);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);


        sharedPreferences = getSharedPreferences(dataUserCache, modo_private);
        editor = sharedPreferences.edit();

        Picasso.get().load("https://i.pinimg.com/736x/1b/90/ff/1b90ff6431a16239565a43ecdc989394.jpg").into(img1);
        Picasso.get().load("https://i.pinimg.com/736x/a6/f4/eb/a6f4ebd2e8926faa1cd16074ca10a0b2.jpg").into(img2);
        Picasso.get().load("https://i.pinimg.com/736x/3b/da/cc/3bdacccbd47c06dbf60e5bfa1b6e1c88.jpg").into(img3);
        Picasso.get().load("https://i.pinimg.com/736x/d3/54/bb/d354bb4b90c4ef6666b2b556d9e79486.jpg").into(img4);
        Picasso.get().load("https://i.pinimg.com/736x/c5/b1/33/c5b1334281f0922a4a72c1989f4613fa.jpg").into(img5);
        Picasso.get().load("").into(img6);

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

        Intent i = new Intent(TerceraPantalla.this, MainActivity.class);
        startActivity(i);

        finish();
    }
}