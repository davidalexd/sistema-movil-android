package com.example.myapplicationcomputo01senati;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//para trabajar con imagenes
import com.example.myapplicationcomputo01senati.modeloBD.claseConexionProductos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class InsertarProductos extends AppCompatActivity implements View.OnClickListener {
    Button btnselecregimg,btngraregimgpro;
    ImageView imgregpro;

    EditText txtnompro,txtprecio,txtcantidad;
    TextView txtcategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_productos);

        btnselecregimg =(Button) findViewById(R.id.btnselecregimg);
        btnselecregimg.setOnClickListener(this);

        btngraregimgpro =(Button) findViewById(R.id.btngraregimgpro);
        btngraregimgpro.setOnClickListener(this);

        imgregpro =(ImageView) findViewById(R.id.imgregpro);

        txtnompro = (EditText) findViewById(R.id.txtregnompro);
        txtprecio = (EditText) findViewById(R.id.txtregprepro);
        txtcantidad = (EditText) findViewById(R.id.txtcantregpro);
        txtcategoria = (TextView) findViewById(R.id.txtcategoria);

        Bundle parametro = this.getIntent().getExtras();
        txtcategoria.setText(parametro.getString("categoria"));




    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnselecregimg:
                mostrarDialogoOpciones();
                break;
            case R.id.btngraregimgpro:
                String nompro = txtnompro.getText().toString();
                String categoria = txtcategoria.getText().toString();
                Double precio = Double.parseDouble(txtprecio.getText().toString());
                Long cantidad= Long.parseLong(txtcantidad.getText().toString());


                grabarProducto(nompro,categoria,precio,cantidad,bitmap);


                break;
        }
    }

    private  static final int codigoSeleccion=1;
    private void mostrarDialogoOpciones(){
        final CharSequence[] opciones={"Elegir Galeria","Cancelar"};
        final AlertDialog.Builder alerta=new AlertDialog.Builder(this);
        alerta.setTitle("Elija una opcion");

        alerta.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(opciones[i].equals("Elegir Galeria")){
                    Intent ventana=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    ventana.setType("image/");
                    startActivityForResult(ventana.createChooser(ventana,"Seleccione"),codigoSeleccion);
                }
            }
        });
        alerta.show();

    }
    Bitmap bitmap;
    public void onActivityResult(int recuperarCodigo,int resultadoCodigo,Intent data){
        super.onActivityResult(recuperarCodigo,recuperarCodigo,data);

        switch (recuperarCodigo){
            case codigoSeleccion:
                Uri  ruta=data.getData();
                imgregpro.setImageURI(ruta);
                try{
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),ruta);
                    imgregpro.setImageBitmap(bitmap);
                }catch (IOException e){

                }
                break;

        }
    }
    public  void grabarProducto(String nombre,String categoria,Double precio, long cantidad,Bitmap bitmap){

        ByteArrayOutputStream tamañoArchivo = new ByteArrayOutputStream(20480);
        bitmap.compress(Bitmap.CompressFormat.PNG,0,tamañoArchivo);
        byte[] arreglo= tamañoArchivo.toByteArray();

        claseConexionProductos con = new claseConexionProductos(this,"BDProductos",null,1);
        SQLiteDatabase consulta= con.getReadableDatabase();

        Cursor cursor= consulta.rawQuery("select * from productos",null);

        long total=cursor.getCount()+1;

        SQLiteDatabase insertar= con.getWritableDatabase();
        if(insertar !=null){
            String cadenasql="insert into productos(id,categoria,nom,precio,cantidad,imagen) values(?,?,?,?,?,?)";

            SQLiteStatement fila = insertar.compileStatement(cadenasql);
            fila.clearBindings();
            fila.bindLong(1,total);
            fila.bindString(2,categoria);
            fila.bindString(3,nombre);
            fila.bindDouble(4,precio);
            fila.bindLong(5,cantidad);
            fila.bindBlob(6,arreglo);
            fila.executeInsert();
            consulta.close();
            insertar.close();
            Toast.makeText(this,"Grabado Ok",Toast.LENGTH_LONG).show();
        }

    }




}