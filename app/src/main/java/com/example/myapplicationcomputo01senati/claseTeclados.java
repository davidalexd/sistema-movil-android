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

public class claseTeclados extends Fragment implements  View.OnClickListener{
    ImageView imagen;
    Button btninseteclados;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //crear vista
        View raiz =inflater.inflate(R.layout.fragment_teclados,container,false);
        imagen = (ImageView) raiz.findViewById(R.id.imgteclados);
        imagen.setOnClickListener(this);

        btninseteclados = (Button) raiz.findViewById(R.id.btninseteclados);
        btninseteclados.setOnClickListener(this);
        return  raiz;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgteclados:
                Intent ventana= new Intent(getActivity().getApplication(),MainTeclados.class);
                ventana.putExtra("categoria","Teclados");
                startActivity(ventana);
                break;

            case R.id.btninseteclados:
                Intent ventana2= new Intent(getActivity().getApplication(),InsertarProductos.class);
                ventana2.putExtra("categoria","Teclados");
                startActivity(ventana2);
                break;
        }

    }
}
