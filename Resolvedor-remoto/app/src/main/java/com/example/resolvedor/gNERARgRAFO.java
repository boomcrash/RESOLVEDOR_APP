package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class gNERARgRAFO extends AppCompatActivity {
    Spinner spinner,spinner2;
    EditText time;
    TextView y;
    Button añadir, graficar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnerarg_rafo);
        spinner=findViewById(R.id.spinner2);
        spinner2=findViewById(R.id.spinner4);
        time=findViewById(R.id.spinner5);
        añadir=findViewById(R.id.añadir);
        graficar=findViewById(R.id.graficar);
        y=findViewById(R.id.y);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.actividades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.predecesores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String uno=spinner.getSelectedItem().toString();
                String dos=spinner2.getSelectedItem().toString();
                String tres=time.getText().toString();
                y.append(uno+"        "+dos+"        "+tres+"\n");
            }
        });
        graficar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(gNERARgRAFO.this, pert_Grafo.class);
                startActivity(menu);
            }
        });

    }
}