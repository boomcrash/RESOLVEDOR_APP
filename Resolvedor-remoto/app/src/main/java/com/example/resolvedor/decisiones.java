package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class decisiones extends AppCompatActivity {
Button min_max;
EditText desde,hasta;
TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decisiones);
        texto =findViewById(R.id.texto);
        min_max =findViewById(R.id.min_max);
        desde =findViewById(R.id.desde);
        hasta =findViewById(R.id.hasta);
        min_max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!desde.getText().toString().isEmpty()&&!hasta.getText().toString().isEmpty()){
                    int filas_columna=Integer.parseInt(hasta.getText().toString())-Integer.parseInt(desde.getText().toString());
                    Toast.makeText(decisiones.this, "TABLA : "+filas_columna+"*"+filas_columna, Toast.LENGTH_SHORT).show();
                    texto.setText("-\n");
                    for(int i=Integer.parseInt(desde.getText().toString());i<=Integer.parseInt(hasta.getText().toString());i++){
                        texto.append(i+"\t");
                    }
                    texto.append("\n");
                }
            }
        });

    }
}