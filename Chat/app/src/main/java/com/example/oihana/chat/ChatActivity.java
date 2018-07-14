package com.example.oihana.chat;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivity extends AppCompatActivity {

    private EditText eTusuario;
    private EditText eTpassword;
    private Button bTingresar;
    private RequestQueue mRequest;
    private VolleyRP volley;
    private static String IP="https://judithhs.000webhostapp.com/ArchivosPHP/Login_GETID.php?id=";
    private String USER="";
    private String PASSWORD="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        volley=VolleyRP.getInstance(this);
        mRequest=volley.getRequestQueue();
        eTusuario=(EditText) findViewById(R.id.eTusuario);
        eTpassword=(EditText) findViewById(R.id.eTpaasword);
        bTingresar=(Button) findViewById(R.id.bTingresar);

        bTingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               verificarLogin(eTusuario.getText().toString().toLowerCase(),eTpassword.getText().toString().toLowerCase());

                eTusuario.setText("");
                eTpassword.setText("");
            }
        });


    }

    public void verificarLogin(String user,String pass){
        USER=user;
        PASSWORD=pass;
        //Toast.makeText(this, "El usuario es: "+user+"La contraseña es: "+pass, Toast.LENGTH_SHORT).show();
        solicitudJSON(IP+user);
    }
    public void solicitudJSON(String URL){
        JsonObjectRequest solicitud=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                verificarPassword(datos);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ChatActivity.this, "Ocurrio un error por favor comuniquese como el administrador", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mRequest,this,volley);
    }

    public void verificarPassword(JSONObject datos){
        //Controlar el JSON

        //Toast.makeText(this, "Los datos son: "+datos.toString(), Toast.LENGTH_SHORT).show();
        try {
            String estado=datos.getString("resultado");
            if(estado.equals("CC")){
               JSONObject Jsondatos =new JSONObject(datos.getString("datos"));
               String usuario=Jsondatos.getString("id");
               String pass=Jsondatos.getString("password");

                if(USER.equals(usuario)&& PASSWORD.equals(pass)){
                    Toast.makeText(this, "Usted se ha logeado correctamente ", Toast.LENGTH_SHORT).show();
                    //Transportar a otra actividad
                    Intent i=new Intent(this,NuevaActividad.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {

        }

    }
}
