package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pert_duracion extends AppCompatActivity {
    EditText P,D2,S2;
    TextView A2;
    Button C2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pert_duracion);
        P=findViewById(R.id.P);
        D2=findViewById(R.id.D2);
        S2=findViewById(R.id.S2);
        A2=findViewById(R.id.A2);
        C2=findViewById(R.id.C2);
        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!P.getText().toString().isEmpty()&&!D2.getText().toString().isEmpty()&&!S2.getText().toString().isEmpty()){
                    Double Z=(Double.parseDouble(P.getText().toString())*Double.parseDouble(S2.getText().toString()))+Double.parseDouble(D2.getText().toString());
                    A2.setText("resultado -> "+Math.round(Z*100.0)/100.0+"\nNOTA:Busque este valor en la tabla de probabilidades, y anotelo abajo!");
                    P.setText("");
                    D2.setText("");
                    S2.setText("");
                }else Toast.makeText(pert_duracion.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}