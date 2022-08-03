package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Inventario extends AppCompatActivity {
Button r1,r2,r4,r5;
EditText d,s,h,d1,L,D1,Q1,N;
TextView respuesta,respuesta2,respuesta4,respuesta5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r4=findViewById(R.id.r4);
        r5=findViewById(R.id.r5);

        d=findViewById(R.id.D);
        s=findViewById(R.id.S);

        d1=findViewById(R.id.d);
        L=findViewById(R.id.L);

        D1=findViewById(R.id.D1);
        Q1=findViewById(R.id.Q1);

        N=findViewById(R.id.N);

        h=findViewById(R.id.H);
        respuesta=findViewById(R.id.respuesta);
        respuesta2=findViewById(R.id.respuesta2);
        respuesta4=findViewById(R.id.respuesta4);
        respuesta5=findViewById(R.id.respuesta5);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!d.getText().toString().isEmpty()&&!s.getText().toString().isEmpty()&&!h.getText().toString().isEmpty()){
                    double valor= Math.sqrt(((2*Double.parseDouble(d.getText().toString())*Double.parseDouble(s.getText().toString()))/Double.parseDouble(h.getText().toString())));
                    respuesta.setText(String.valueOf(valor));
                }else{
                    Toast.makeText(Inventario.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }

            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!d1.getText().toString().isEmpty()&&!L.getText().toString().isEmpty()){
                    double valor=Double.parseDouble(d1.getText().toString())*Double.parseDouble(L.getText().toString());
                    respuesta2.setText(String.valueOf(valor));

                }else{
                    Toast.makeText(Inventario.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!D1.getText().toString().isEmpty()&&!Q1.getText().toString().isEmpty()){
                    double valor=Double.parseDouble(D1.getText().toString())/Double.parseDouble(Q1.getText().toString());
                    respuesta4.setText(String.valueOf(valor));

                }else{
                    Toast.makeText(Inventario.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!N.getText().toString().isEmpty()){
                    double valor=(365/Double.parseDouble(N.getText().toString()));
                    respuesta5.setText(String.valueOf(valor));

                }else{
                    Toast.makeText(Inventario.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}