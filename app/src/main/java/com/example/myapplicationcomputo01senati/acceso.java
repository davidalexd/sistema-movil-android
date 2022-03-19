package com.example.myapplicationcomputo01senati;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import  android.content.DialogInterface;

import com.example.myapplicationcomputo01senati.modeloBD.*;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
public class acceso extends AppCompatActivity implements View.OnClickListener{
// declara tu variable
    TextView etiqueta;
    ImageView imagen;
    Button btningresar;
    EditText txtusuario, txtclave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        //crear el objeto
        etiqueta = (TextView) findViewById(R.id.btncreate);
        imagen = (ImageView) findViewById(R.id.imgclose);
        //boton = (Button) findViewById(R.id.btnini);

        //asignar el evento click

        etiqueta.setOnClickListener(this);
        imagen.setOnClickListener(this);
        //boton.setOnClickListener(this);

        btningresar = (Button) findViewById(R.id.btnini);
        btningresar.setOnClickListener(this);

        txtusuario = (EditText) findViewById(R.id.txtuser);
        txtclave = (EditText) findViewById(R.id.txtpass);
    }
    claseConexion con;
    claseUsuarios usu;

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btncreate:
                Intent ventana=new Intent(acceso.this,registro.class);
                startActivity(ventana);
                break;
            case R.id.imgclose:
                AlertDialog.Builder dialogo= new AlertDialog.Builder(this);
                dialogo.setMessage("Esta seguro salir?");
                dialogo.setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                });
                dialogo.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dialogo.show();
                break;
            case R.id.btnini:
                con = new claseConexion(this,"BDUsuarios",null,1);
                usu = new claseUsuarios(null,null,null,null,null);

                SQLiteDatabase bd= con.getWritableDatabase();

                String cadenasql="select * from usuarios where usuario='" + txtusuario.getText().toString() +
                        "' and clave= '" + txtclave.getText().toString() + "'";

                //Toast.makeText(this,cadenasql,Toast.LENGTH_LONG).show();

                Cursor cursor= bd.rawQuery(cadenasql,null);

                if(cursor.getCount()>0)
                {
                    Toast.makeText(this,"Bienvenido: "+ txtusuario.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent ventana2= new Intent(acceso.this,panelPrincipal.class);
                    startActivity(ventana2);
                }else{
                    Toast.makeText(this,"Acceso denegado",Toast.LENGTH_LONG).show();

                }

                break;
        }

    }
}