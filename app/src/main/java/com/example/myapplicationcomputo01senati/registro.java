package com.example.myapplicationcomputo01senati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationcomputo01senati.modeloBD.*;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class registro extends AppCompatActivity implements View.OnClickListener {
    TextView salir;
    Button boton;
    EditText cajanon,cajaape,cajausuario,cajacorreo,cajaclave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        salir = (TextView) findViewById(R.id.btnexit);
        salir.setOnClickListener(this);

        boton = (Button) findViewById(R.id.btnregister);
        boton.setOnClickListener(this);

        cajanon= (EditText) findViewById(R.id.txtcreatename);
        cajaape= (EditText) findViewById(R.id.txtcreatelastname);
        cajausuario= (EditText) findViewById(R.id.txtcreateuser);
        cajacorreo =(EditText) findViewById(R.id.txtcreatemail);
        cajaclave= (EditText) findViewById(R.id.txtcreatepass);
    }
    claseConexion con;
    claseUsuarios usu;

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnexit:
                finish();
                break;
            case R.id.btnregister:
                con = new claseConexion(this,"BDUsuarios",null,1);
                usu = new claseUsuarios(null,null,null,null,null);
//activar el permiso de escritura
                SQLiteDatabase bd= con.getWritableDatabase();
//verificar si esta conectado

                if(bd !=null)
                {
                    String cadenasql="insert into usuarios(nom,ape,usuario,correo,clave) "
                            + "values('" + cajanon.getText() + "','" + cajaape.getText()
                            + "','" + cajausuario.getText() + "','" + cajacorreo.getText()
                            + "','" + cajaclave.getText() + "')";
                    bd.execSQL(cadenasql);
                    Toast.makeText(this,"grabador OK",Toast.LENGTH_LONG).show();
                }

                break;
        }

    }
}