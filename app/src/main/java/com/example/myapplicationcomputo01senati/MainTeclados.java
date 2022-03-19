package com.example.myapplicationcomputo01senati;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.myapplicationcomputo01senati.modeloBD.claseConexionProductos;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class MainTeclados extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    ArrayList<String> arreglo;
    ImageView imgproducto;
    ListView Lista;
    claseConexionProductos objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teclado);
        Lista = (ListView) findViewById(R.id.lv3);
        Lista.setOnItemClickListener(this);

        imgproducto =(ImageView) findViewById(R.id.imgregteclados);

        objeto= new claseConexionProductos(this,"BDProductos",null,1);
        SQLiteDatabase consulta=objeto.getReadableDatabase();

        arreglo = new ArrayList<String>();
        Bundle parametro = this.getIntent().getExtras();
        String categoria = parametro.getString("categoria");

        Cursor cursor = consulta.rawQuery(String.format("Select * from productos where categoria = '%s'",categoria),null);
        if(cursor.moveToFirst()){
            do{
                String id=cursor.getString(0);
                String nom=cursor.getString(2);
                String precio=cursor.getString(3);
                String cantidad=cursor.getString(4);

                String cadena= id + "  " + nom + "    S/." + precio + "    cant: " + cantidad+"   ";

                arreglo.add(cadena);
            }while(cursor.moveToNext());

            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arreglo);
            Lista.setAdapter(adaptador);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = (String)Lista.getItemAtPosition(i);
        Long id = Long.parseLong(String.valueOf(text.charAt(0)));
        imgproducto.setImageBitmap(mostrarImagen(id));

    }
    public Bitmap mostrarImagen(Long id){
        SQLiteDatabase consulta= objeto.getReadableDatabase();
        String cadenasql = String.format("select * from productos where id= %d",id);

        Cursor cursor = consulta.rawQuery(cadenasql,new String[]{});
        Bitmap bitmap= null;
        if(cursor.moveToFirst()){
            byte[]  arreglo=cursor.getBlob(5);
            ByteArrayInputStream tamaArchivo= new ByteArrayInputStream(arreglo);
            bitmap = BitmapFactory.decodeStream(tamaArchivo);
        }
        if(cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        consulta.close();
        return bitmap;

    }
}