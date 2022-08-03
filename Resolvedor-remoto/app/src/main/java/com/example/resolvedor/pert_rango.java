package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class pert_rango extends AppCompatActivity {
    EditText duracion,sig;
    Button rango;
    Spinner spinner;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pert_rango);
        duracion=findViewById(R.id.duracion);
        sig=findViewById(R.id.sig);
        rango=findViewById(R.id.rango);
        spinner=findViewById(R.id.spinner);
        answer=findViewById(R.id.answer);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        rango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!duracion.getText().toString().isEmpty()&&!sig.getText().toString().isEmpty()) {
                    if (spinner.getSelectedItem().equals(">68")) {
                        Double valor1 = Double.parseDouble(duracion.getText().toString()) + (1 * Double.parseDouble(sig.getText().toString()));
                        Double valor2 = Double.parseDouble(duracion.getText().toString()) - (1 * Double.parseDouble(sig.getText().toString()));
                        if (valor1 > valor2) {
                            answer.setText("EL RANGO DE CULMINACION DE PROYECTO ES : (" + Math.round(valor2 * 100.0) / 100.0 + "," + Math.round(valor1 * 100.0) / 100.0 + ")");
                        } else {
                            answer.setText("EL RANGO DE CULMINACION DE PROYECTO ES : (" + Math.round(valor1 * 100.0) / 100.0 + "," + Math.round(valor2 * 100.0) / 100.0 + ")");
                        }
                        duracion.setText("");
                        sig.setText("");

                    } else if (spinner.getSelectedItem().equals(">95")) {
                        Double valor1 = Double.parseDouble(duracion.getText().toString()) + (2 * Double.parseDouble(sig.getText().toString()));
                        Double valor2 = Double.parseDouble(duracion.getText().toString()) - (2 * Double.parseDouble(sig.getText().toString()));
                        if (valor1 > valor2) {
                            answer.setText("EL RANGO DE CULMINACION DE PROYECTO ES : (" + Math.round(valor2 * 100.0) / 100.0 + "," + Math.round(valor1 * 100.0) / 100.0 + ")");
                        } else {
                            answer.setText("EL RANGO DE CULMINACION DE PROYECTO ES : (" + Math.round(valor1 * 100.0) / 100.0 + "," + Math.round(valor2 * 100.0) / 100.0 + ")");
                        }
                        duracion.setText("");
                        sig.setText("");

                    } else if (spinner.getSelectedItem().equals(">99")) {
                        Double valor1 = Double.parseDouble(duracion.getText().toString()) + (3 * Double.parseDouble(sig.getText().toString()));
                        Double valor2 = Double.parseDouble(duracion.getText().toString()) - (3 * Double.parseDouble(sig.getText().toString()));
                        if (valor1 > valor2) {
                            answer.setText("EL RANGO DE CULMINACION DE PROYECTO ES : (" + Math.round(valor2 * 100.0) / 100.0 + "," + Math.round(valor1 * 100.0) / 100.0 + ")");
                        } else {
                            answer.setText("EL RANGO DE CULMINACION DE PROYECTO ES : (" + Math.round(valor1 * 100.0) / 100.0 + "," + Math.round(valor2 * 100.0) / 100.0 + ")");
                        }
                        duracion.setText("");
                        sig.setText("");

                    }
                }else Toast.makeText(pert_rango.this, "RELLENE LOS CAMPOS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}