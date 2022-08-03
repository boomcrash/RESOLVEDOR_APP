package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_INV extends AppCompatActivity {
Button costo,formulas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inv);
        costo=findViewById(R.id.costo);
        formulas=findViewById(R.id.formulas);
        formulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(menu_INV.this,Inventario.class);
                startActivity(menu);
            }
        });

        costo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(menu_INV.this,Inventario2.class);
                startActivity(menu);
            }
        });
    }
}