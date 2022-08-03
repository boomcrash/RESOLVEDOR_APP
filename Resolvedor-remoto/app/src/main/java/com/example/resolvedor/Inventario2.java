package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inventario2 extends AppCompatActivity {
Button r;
EditText D,i,Q,S,H;
TextView respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario2);
        r=findViewById(R.id.r);

        D=findViewById(R.id.D);
        i=findViewById(R.id.i);
        Q=findViewById(R.id.Q);
        S=findViewById(R.id.S);
        H=findViewById(R.id.H);

        respuesta=findViewById(R.id.respuesta);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double valor=(Double.parseDouble(D.getText().toString())*Double.parseDouble(i.getText().toString()))+((Double.parseDouble(D.getText().toString())/Double.parseDouble(Q.getText().toString()))*Double.parseDouble(S.getText().toString()))+((Double.parseDouble(Q.getText().toString())/2)*Double.parseDouble(H.getText().toString()));
                respuesta.setText(String.valueOf(valor));
            }
        });
    }
}