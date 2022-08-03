package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pert_culminacion extends AppCompatActivity {
    EditText T,D,S,valor;
    TextView A,a;
    Button C,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pert_culminacion);
        T=findViewById(R.id.T);
        D=findViewById(R.id.D);
        S=findViewById(R.id.S);
        A=findViewById(R.id.A);
        C=findViewById(R.id.C);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!T.getText().toString().isEmpty()&&!D.getText().toString().isEmpty()&&!S.getText().toString().isEmpty()){
                    Double Z=(Double.parseDouble(T.getText().toString())-Double.parseDouble(D.getText().toString()))/Double.parseDouble(S.getText().toString());
                    A.setText("resultado -> "+Math.round(Z*100.0)/100.0+"\nNOTA:Busque este valor en la tabla de probabilidades, y anotelo abajo!");
                    T.setText("");
                    D.setText("");
                    S.setText("");
                }else Toast.makeText(pert_culminacion.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
            }
        });
        c=findViewById(R.id.c);
        valor=findViewById(R.id.valor);
        a=findViewById(R.id.a);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!valor.getText().toString().isEmpty()){
                    Double Z=(1-Double.parseDouble(valor.getText().toString()));
                    a.setText("probababilidad de culminacion-> "+Z);
                    valor.setText("");
                }else Toast.makeText(pert_culminacion.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}