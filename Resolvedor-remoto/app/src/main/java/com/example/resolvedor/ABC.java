package com.example.resolvedor;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ABC extends AppCompatActivity {
    EditText id,demanda,coste;
    EditText id3,demanda3,coste3;
    Button añadir,resolver;
    ScrollView panel,panel2;
    TextView text1,text2;
    ArrayList<Valores> valores=new ArrayList<Valores>();
    ArrayList<Coste_total> total=new ArrayList<Coste_total>();
    ArrayList<Porcentaje> porcentaje=new ArrayList<Porcentaje>();
    ArrayList<Double> aux=new ArrayList<Double>();
    ArrayList<Porcentaje> porcentaje_final=new ArrayList<Porcentaje>();
    ArrayList<Porcentaje> porcentaje_final2=new ArrayList<Porcentaje>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);
        id=findViewById(R.id.id);
        demanda=findViewById(R.id.demanda);
        coste=findViewById(R.id.coste);
        id3=findViewById(R.id.id3);
        demanda3=findViewById(R.id.demanda3);
        coste3=findViewById(R.id.coste3);
        añadir=findViewById(R.id.añadir);
        resolver=findViewById(R.id.resolver);
        panel=findViewById(R.id.panel);
        panel2=findViewById(R.id.panel2);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text1.setText("id"+"-"+"demanda"+"-"+"coste/u"+"\n");
        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!id.getText().toString().isEmpty()&&!demanda.getText().toString().isEmpty()&&!coste.getText().toString().isEmpty()){
                    valores.add(new Valores(id.getText().toString(),Double.parseDouble(coste.getText().toString()),Double.parseDouble(demanda.getText().toString())));
                    text1.append(id.getText().toString()+"-"+demanda.getText().toString()+"-"+coste.getText().toString()+"\n");
                    id.setText("");
                    demanda.setText("");
                    coste.setText("");
                }else{
                    Toast.makeText(ABC.this, "LLENE LOS CAMPOS ID-DEMANDA-COSTE", Toast.LENGTH_SHORT).show();
                }

            }
        });
        resolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id3.getText().toString().isEmpty() && !demanda3.getText().toString().isEmpty() && !coste3.getText().toString().isEmpty()) {

                    double sumatoria = 0;
                    for (int i = 0; i < valores.size(); i++) {
                        total.add(new Coste_total(valores.get(i).getId(), (valores.get(i).getDemanda() * valores.get(i).getCoste())));
                        sumatoria += (valores.get(i).getDemanda() * valores.get(i).getCoste());
                    }
                    DecimalFormat formato = new DecimalFormat("#.##");
                    text2.append("PASO #1" + "\n");
                    text2.append("ID" + "-" + "COSTE TOTAL" + "-" + "PORCENTAJE" + "\n");
                    for (int i = 0; i < total.size(); i++) {
                        porcentaje.add(new Porcentaje(total.get(i).getId(), total.get(i).getCoste_total(), Double.parseDouble(formato.format(((total.get(i).getCoste_total() / sumatoria) * 100)))));
                        aux.add(Double.parseDouble(formato.format(((total.get(i).getCoste_total() / sumatoria) * 100))));
                        text2.append(total.get(i).getId() + "-" + total.get(i).getCoste_total() + "-" + formato.format(((total.get(i).getCoste_total() / sumatoria) * 100)) + "\n");

                    }
                    text2.append(String.valueOf(sumatoria));

                    text2.append("\n" + "PASO #2" + "\n");
                    text2.append("\n" + "ORDENADO" + "\n");
                    text2.append("ID" + "-" + "COSTE TOTAL" + "-" + "PORCENTAJE" + "\n");
                    Collections.sort(aux, Collections.reverseOrder());
                    for (int i = 0; i < aux.size(); i++) {
                        for (int j = 0; j < porcentaje.size(); j++) {
                            if (aux.get(i) == porcentaje.get(j).getPorciento()) {
                                porcentaje_final.add(new Porcentaje(porcentaje.get(j).getId(), porcentaje.get(j).getCoste_total(), porcentaje.get(j).getPorciento()));
                            }
                        }
                    }
                    int contador = 0;
                    for (int i = 0; i < porcentaje_final.size(); i++) {
                        contador = 0;
                        for (int j = 0; j < porcentaje_final.size(); j++) {
                            if (contador == 2) {
                                porcentaje_final.remove(i);
                                break;
                            } else if (porcentaje_final.get(i).getId() == porcentaje_final.get(j).getId()) {
                                contador++;
                            }
                        }
                    }
                    for (int i = 0; i < porcentaje_final.size(); i++) {
                        text2.append(porcentaje_final.get(i).getId() + "-" + porcentaje_final.get(i).getCoste_total() + "-" + formato.format(porcentaje_final.get(i).getPorciento()) + "\n");

                    }


                    text2.append("\n" + "PASO #3" + "\n");
                    text2.append("\n" + "SUMATORIA" + "\n");
                    text2.append("ID" + "-" + "COSTE TOTAL" + "-" + "PORCENTAJE" + "\n");
                    for (int i = 0; i < porcentaje_final.size(); i++) {
                        try {
                            if (i == 0) {
                                porcentaje_final2.add(new Porcentaje(porcentaje_final.get(i).getId(), porcentaje_final.get(i).getCoste_total(), (porcentaje_final.get(i).getPorciento())));
                            } else if (i > 0) {
                                porcentaje_final2.add(new Porcentaje(porcentaje_final.get(i).getId(), porcentaje_final.get(i).getCoste_total(), (porcentaje_final2.get(i - 1).getPorciento() + porcentaje_final.get(i).getPorciento())));
                            }
                        } catch (Exception e) {
                            System.err.println("ERROR");
                        }
                        text2.append(porcentaje_final2.get(i).getId() + "-" + porcentaje_final2.get(i).getCoste_total() + "-" + formato.format(porcentaje_final2.get(i).getPorciento()) + "\n");

                    }

                    text2.append("\n" + "RESULTADO FINAL" + "\n");

                    text2.append("A" + "-" + 0 + "-" + (Double.parseDouble(id3.getText().toString())) + "\n");
                    text2.append("B" + "-" + (Double.parseDouble(id3.getText().toString()) + 0.01) + "-" + ((Double.parseDouble(id3.getText().toString()) + (Double.parseDouble(demanda3.getText().toString())))) + "\n");
                    text2.append("C" + "-" + (Double.parseDouble(id3.getText().toString()) + Double.parseDouble(demanda3.getText().toString()) + 0.01) + "-" + (Double.parseDouble(id3.getText().toString()) + Double.parseDouble(demanda3.getText().toString()) + Double.parseDouble(coste3.getText().toString())) + "\n");

                    text2.append("\n" + "ENTONCES:" + "\n");
                    String id_final = "";
                    for (int i = 0; i < porcentaje_final2.size(); i++) {
                        if (porcentaje_final2.get(i).getPorciento() >= 0 && porcentaje_final2.get(i).getPorciento() <= Double.parseDouble(id3.getText().toString())) {
                            id_final += porcentaje_final2.get(i).getId() + "-";
                        }
                    }
                    text2.append("\n" + "A:   " + id_final + "\n");
                    id_final = "";
                    for (int i = 0; i < porcentaje_final2.size(); i++) {
                        if (porcentaje_final2.get(i).getPorciento() >= (Double.parseDouble(id3.getText().toString()) + 0.01) && porcentaje_final2.get(i).getPorciento() <= (Double.parseDouble(id3.getText().toString()) + Double.parseDouble(demanda3.getText().toString()))) {
                            id_final += porcentaje_final2.get(i).getId() + "-";
                        }
                    }
                    text2.append("\n" + "B:   " + id_final + "\n");
                    id_final = "";
                    for (int i = 0; i < porcentaje_final2.size(); i++) {
                        if (porcentaje_final2.get(i).getPorciento() >= (Double.parseDouble(id3.getText().toString()) + Double.parseDouble(demanda3.getText().toString()) + 0.01) && porcentaje_final2.get(i).getPorciento() <= (0.01+Double.parseDouble(id3.getText().toString()) + Double.parseDouble(demanda3.getText().toString()) + Double.parseDouble(coste3.getText().toString()))) {
                            id_final += porcentaje_final2.get(i).getId() + "-";
                        }
                    }
                    text2.append("\n" + "C:   " + id_final + "\n");


                    valores.clear();
                    total.clear();
                    porcentaje.clear();
                    aux.clear();
                    porcentaje_final.clear();
                }else{
                    Toast.makeText(ABC.this, "LLENE LOS CAMPOS A-B-C", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

}
class Valores{
    String id;
    double demanda,coste;

    public Valores(String id, double demanda, double coste) {
        this.id = id;
        this.demanda = demanda;
        this.coste = coste;
    }

    public Valores() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDemanda() {
        return demanda;
    }

    public void setDemanda(double demanda) {
        this.demanda = demanda;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}

class Coste_total{
    String id;
    double coste_total;

    public Coste_total(String id, double coste_total) {
        this.id = id;
        this.coste_total = coste_total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCoste_total() {
        return coste_total;
    }

    public void setCoste_total(double coste_total) {
        this.coste_total = coste_total;
    }
}

class Porcentaje{
    String id;
    double coste_total,porciento;

    public Porcentaje(String id, double coste_total, double porciento) {
        this.id = id;
        this.coste_total = coste_total;
        this.porciento = porciento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCoste_total() {
        return coste_total;
    }

    public void setCoste_total(double coste_total) {
        this.coste_total = coste_total;
    }

    public double getPorciento() {
        return porciento;
    }

    public void setPorciento(double porciento) {
        this.porciento = porciento;
    }
}