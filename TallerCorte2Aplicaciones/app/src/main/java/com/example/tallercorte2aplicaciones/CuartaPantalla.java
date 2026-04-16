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

public class CuartaPantalla extends AppCompatActivity {

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

        Picasso.get().load("https://i.pinimg.com/1200x/a6/28/93/a62893a4f06483080a27aa0cab1305a6.jpg").into(img1);
        Picasso.get().load("https://i.pinimg.com/736x/9d/0a/a9/9d0aa91dacf9f2ea4eca1b0b52ce2bef.jpg").into(img2);
        Picasso.get().load("https://i.pinimg.com/1200x/03/5a/a7/035aa7ca84983d7085040bb0523a91bc.jpg").into(img3);
        Picasso.get().load("https://i.pinimg.com/736x/c7/8f/72/c78f72665fb5f9e3613d61c77a4eff9e.jpg").into(img4);
        Picasso.get().load("https://i.pinimg.com/736x/8a/0c/54/8a0c541afe9c51db74dd48ad4128de59.jpg").into(img5);
        Picasso.get().load("https://i.pinimg.com/1200x/2b/69/7b/2b697b3ca95261438b09f664823b9e4a.jpg").into(img6);

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

        Intent i = new Intent(CuartaPantalla.this, MainActivity.class);
        startActivity(i);

        finish();
    }
}