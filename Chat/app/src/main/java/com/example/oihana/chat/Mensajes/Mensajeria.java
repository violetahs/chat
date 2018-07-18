package com.example.oihana.chat.Mensajes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.oihana.chat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oihana on 17/07/2018.
 */

public class Mensajeria extends AppCompatActivity {

    private RecyclerView rv;
    private List<MensajeDeTexto> mensajeDeTextos;
    private MensajesAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensajeria);
        mensajeDeTextos=new ArrayList<>();
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        rv=(RecyclerView) findViewById(R.id.rvMensajes);

        for(int i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar =new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("Hola"+i);
            mensajeDeTextoAuxiliar.setTipoMensaje(1);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:23"+i);
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }

        adapter=new MensajesAdapter(mensajeDeTextos);
        rv.setAdapter(adapter);






        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
