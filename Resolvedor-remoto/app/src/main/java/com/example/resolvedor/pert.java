package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pert extends AppCompatActivity {
    EditText op,pro,pe,varianza;
    TextView answer1, answer2;
    Button calcular,sigma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pert);
        op=findViewById(R.id.op);
        pro=findViewById(R.id.pro);
        pe=findViewById(R.id.pe);
        varianza=findViewById(R.id.varianza);
        answer1=findViewById(R.id.answer1);
        answer2=findViewById(R.id.answer2);
        calcular=findViewById(R.id.calcular);
        sigma=findViewById(R.id.sigma);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tiempo,varia;
                if(!op.getText().toString().isEmpty()&&!pro.getText().toString().isEmpty()&&!pe.getText().toString().isEmpty()){
                    tiempo=(Double.parseDouble(op.getText().toString())+(4*Double.parseDouble(pro.getText().toString()))+Double.parseDouble(pe.getText().toString()))/6;
                    varia= (double) Math.pow(((Double.parseDouble(pe.getText().toString())-Double.parseDouble(op.getText().toString()))/6),2);
                    answer1.setText("Tiempo Esperado: "+String.valueOf(tiempo)+"\nVarianza: "+String.valueOf(varia)+"   ->"+String.valueOf(Math.round(varia*100.0)/100.0));

                    op.setText("");
                    pro.setText("");
                    pe.setText("");
                }else{
                    Toast.makeText(pert.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }

            }
        });
        sigma.setOnClickListener(new View.OnClickListener() {
            String texto, vector[];
            double resultado=0;

            @Override
            public void onClick(View v) {
                if(!varianza.getText().toString().isEmpty()){
                    texto=varianza.getText().toString();
                    vector=texto.split(" ");
                    for(int i=0;i<vector.length;i++){
                        resultado+=Double.parseDouble(vector[i].toString());
                    }
                    answer2.setText("raiz de "+resultado+"\nsigma = "+String.valueOf(Math.sqrt(resultado)));
                    varianza.setText("");
                }else{
                    Toast.makeText(pert.this, "RELLENE EL CAMPO", Toast.LENGTH_SHORT).show();
                }
            }
        });
       // numberotpmove();
    }
    /*private void numberotpmove() {
        op.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()&&) {
                    pro.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    pe.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }*/

}