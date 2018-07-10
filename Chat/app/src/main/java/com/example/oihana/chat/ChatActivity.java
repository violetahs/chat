package com.example.oihana.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    private EditText eTusuario;
    private EditText eTpassword;
    private Button bTingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
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
        Toast.makeText(this, "El usuario es: "+user+"La contraseña es :"+pass, Toast.LENGTH_SHORT).show();
    }
}
