package com.example.myapplicationcomputo01senati.modeloBD;
//Importar Librerias
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class claseConexion extends SQLiteOpenHelper{

    String creartabla="create table usuarios(nom text,ape text, usuario text, correo text, clave text)";
    public claseConexion(@Nullable Context context,
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
        bd.execSQL("drop table if exists usuarios");
        onCreate(bd);

    }
}
