package com.example.oihana.chat.Mensajes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oihana.chat.R;
import com.example.oihana.chat.Servicios.FireBaseServiceMensajes;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oihana on 17/07/2018.
 */

public class Mensajeria extends AppCompatActivity {

    private RecyclerView rcvMensaje;
    private List<MensajeDeTexto> mensajeDeTextos;
    private MensajesAdapter adapter;
    private Button btnEnviarMensaje;
    private EditText eTEscribirMensaje;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensajeria);
        mensajeDeTextos=new ArrayList<>();
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        rcvMensaje =(RecyclerView) findViewById(R.id.rvMensajes);
        btnEnviarMensaje =(Button) findViewById(R.id.btEnviarMensaje);
        eTEscribirMensaje=(EditText) findViewById(R.id.eTEscribirMensaje);


        for(int i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar =new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("emisor hujiniuuuuuuuuuuuuuubiuu "+i);
            mensajeDeTextoAuxiliar.setTipoMensaje(1);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:23");
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }

        for(int i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar =new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("receptor nnnnnnnuihniujnuiniunijinikkjnjniu "+i);
            mensajeDeTextoAuxiliar.setTipoMensaje(2);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:23");
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }




        adapter=new MensajesAdapter(mensajeDeTextos,this);
        rcvMensaje.setAdapter(adapter);


        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setStackFromEnd(true);
        rcvMensaje.setLayoutManager(lm);

        btnEnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje=eTEscribirMensaje.getText().toString();

                if(!mensaje.isEmpty() )
                createMensaje(mensaje);
            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        setScrollbarChat();



    }

    public void createMensaje(String mensaje){
    MensajeDeTexto mensajeDeTextoAuxiliar = new MensajeDeTexto();
        mensajeDeTextoAuxiliar.setId("0");
        mensajeDeTextoAuxiliar.setMensaje(mensaje);
        mensajeDeTextoAuxiliar.setTipoMensaje(1);
        mensajeDeTextoAuxiliar.setHoraDelMensaje("10:23");
        mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        adapter.notifyDataSetChanged();
        eTEscribirMensaje.setText("");
        setScrollbarChat();
    }

    public void setScrollbarChat(){

        rcvMensaje.scrollToPosition(adapter.getItemCount()-1);
    }
}
