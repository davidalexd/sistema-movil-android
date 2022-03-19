package com.example.myapplicationcomputo01senati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class panelPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_principal);

        Intent ventana= new Intent(panelPrincipal.this, menu.class);
        startActivity(ventana);
    }
}