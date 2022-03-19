package com.example.myapplicationcomputo01senati;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class claseImpresoras extends Fragment implements  View.OnClickListener{
    ImageView imagen;
    Button btninsertarimpresora;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View raiz =inflater.inflate(R.layout.fragment_impresoras,container,false);
        imagen= (ImageView) raiz.findViewById(R.id.imgimpresoras);
        imagen.setOnClickListener(this);

        btninsertarimpresora = (Button) raiz.findViewById(R.id.btninsertarimpresora);
        btninsertarimpresora.setOnClickListener(this);
        return  raiz;
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgimpresoras:
                Intent ventana= new Intent(getActivity().getApplication(),MainImpresoras.class);
                ventana.putExtra("categoria","Impresora");
                startActivity(ventana);
                break;
            case R.id.btninsertarimpresora:
                Intent ventana2= new Intent(getActivity().getApplication(),InsertarProductos.class);
                ventana2.putExtra("categoria","Impresora");
                startActivity(ventana2);
                break;
        }

    }
}
