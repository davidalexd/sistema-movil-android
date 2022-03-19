package com.example.myapplicationcomputo01senati.modeloBD;
//Importar Librerias
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class claseConexionProductos extends SQLiteOpenHelper{

    String creartabla="create table productos(id INTEGER PRIMARY KEY,categoria text,nom text,precio real, cantidad integer, imagen blob)";
    public claseConexionProductos(@Nullable Context context,
                                  @Nullable String name,
                                  @Nullable SQLiteDatabase.CursorFactory factory,
                                  int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(creartabla);


    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("drop table if exists productos");
        onCreate(bd);

    }
}
