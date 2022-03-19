package com.example.myapplicationcomputo01senati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
//IMPORTAR
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    //declaramos el control que usaremos
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //crear el control
        imagen = (ImageView) findViewById(R.id.imglogo);

        temporizador.schedule(proceso, 1,1);

    }

    Timer temporizador = new Timer();
    int contador = 0;
    TimerTask proceso = new TimerTask() {
        @Override
        public void run() {
            contador++;
            System.out.println(contador);
            imagen.setRotation(contador);

            if(contador==1000){
                temporizador.cancel();
                Intent ventana = new Intent(MainActivity.this, acceso.class);
                startActivity(ventana);

            }

        }
    };
}