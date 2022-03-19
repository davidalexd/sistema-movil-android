package com.example.myapplicationcomputo01senati;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplicationcomputo01senati.databinding.*;



public class claseComputadoras  extends Fragment implements  View.OnClickListener
{
    ImageView imagen;
    Button btninsertarproductos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //crear vista
        View raiz =inflater.inflate(R.layout.fragment_computadoras,container,false);

        imagen= (ImageView) raiz.findViewById(R.id.imgcomputadoras);
        imagen.setOnClickListener(this);

        btninsertarproductos = (Button) raiz.findViewById(R.id.btninsertarproductos);
        btninsertarproductos.setOnClickListener(this);

        return  raiz;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgcomputadoras:
                Intent ventana= new Intent(getActivity().getApplication(),MainComputadoras.class);
                ventana.putExtra("categoria","computadora");
                startActivity(ventana);
                Toast.makeText(getContext(), "Computadoras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btninsertarproductos:
                Intent ventana2= new Intent(getActivity().getApplication(),InsertarProductos.class);
                ventana2.putExtra("categoria","computadora");
                startActivity(ventana2);
            break;
        }

    }
}
