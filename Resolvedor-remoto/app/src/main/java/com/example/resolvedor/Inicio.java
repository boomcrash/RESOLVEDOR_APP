package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    Button pert, ABC,INVENTARIO,DECISION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        pert=findViewById(R.id.PERT);
        ABC=findViewById(R.id.ABC);
        INVENTARIO=findViewById(R.id.INVENTARIO);
        DECISION=findViewById(R.id.DECISION);
        pert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Inicio.this, MainActivity.class);
                startActivity(menu);
            }
        });

        ABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Inicio.this, ABC.class);
                startActivity(menu);
            }
        });

        INVENTARIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Inicio.this, menu_INV.class);
                startActivity(menu);
            }
        });

        DECISION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Inicio.this, decisiones.class);
                startActivity(menu);
            }
        });
    }
}